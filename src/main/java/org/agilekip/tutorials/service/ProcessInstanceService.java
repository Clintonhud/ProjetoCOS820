package org.agilekip.tutorials.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.agilekip.tutorials.camunda.CamundaConstants;
import org.agilekip.tutorials.domain.ProcessDefinition;
import org.agilekip.tutorials.domain.ProcessInstance;
import org.agilekip.tutorials.domain.enumeration.StatusProcessInstance;
import org.agilekip.tutorials.repository.ProcessDefinitionRepository;
import org.agilekip.tutorials.repository.ProcessInstanceRepository;
import org.agilekip.tutorials.service.dto.ProcessDefinitionDTO;
import org.agilekip.tutorials.service.dto.ProcessInstanceDTO;
import org.agilekip.tutorials.service.mapper.ProcessInstanceMapper;
import org.agilekip.tutorials.web.rest.errors.BadRequestAlertException;
import org.camunda.bpm.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ProcessInstance}.
 */
@Service
@Transactional
public class ProcessInstanceService {

    private final Logger log = LoggerFactory.getLogger(ProcessInstanceService.class);

    private final ProcessInstanceRepository processInstanceRepository;

    private final ProcessInstanceMapper processInstanceMapper;

    private final ProcessDefinitionService processDefinitionService;

    private final ProcessDefinitionRepository processDefinitionRepository;

    private final RuntimeService runtimeService;

    public ProcessInstanceService(
        ProcessInstanceRepository processInstanceRepository,
        ProcessInstanceMapper processInstanceMapper,
        ProcessDefinitionService processDefinitionService,
        ProcessDefinitionRepository processDefinitionRepository,
        RuntimeService runtimeService
    ) {
        this.processInstanceRepository = processInstanceRepository;
        this.processInstanceMapper = processInstanceMapper;
        this.processDefinitionService = processDefinitionService;
        this.processDefinitionRepository = processDefinitionRepository;
        this.runtimeService = runtimeService;
    }

    public ProcessInstanceDTO create(ProcessInstanceDTO processInstanceDTO) {
        log.debug("Request to create processInstance : {}", processInstanceDTO);
        ProcessInstance processInstance = processInstanceMapper.toEntity(processInstanceDTO);

        Optional<ProcessDefinition> optionalProcessDefinition = processDefinitionRepository.findById(
            processInstance.getProcessDefinition().getId()
        );
        if (!optionalProcessDefinition.isPresent()) {
            throw new BadRequestAlertException(
                "processDefinitionNotFound",
                "" + processInstance.getProcessDefinition().getId(),
                "processDefinitionNotFound"
            );
        }
        ProcessDefinition processDefinition = optionalProcessDefinition.get();
        processInstance.setProcessDefinition(processDefinition);
        processInstance.setCamundaProcessDefinitionId(processDefinition.getCamundaProcessDefinitionId());
        processInstance.setCamundaDeploymentId(processDefinition.getCamundaDeploymentId());
        processInstance.setStartDate(LocalDateTime.now());
        processInstance.setStatus(StatusProcessInstance.RUNNING);

        org.camunda.bpm.engine.runtime.ProcessInstance camundaProcessInstance = runtimeService
            .createProcessInstanceById(processDefinition.getCamundaProcessDefinitionId())
            .businessKey(processInstance.getBusinessKey())
            .execute();

        processInstance.setCamundaProcessInstanceId(camundaProcessInstance.getProcessInstanceId());
        return processInstanceMapper.toDto(processInstanceRepository.save(processInstance));
    }

    public ProcessInstance create(String bpmnProcessDefinitionId, String businessKey, Object processEntity) {
        log.debug("Request to create a processInstance by bpmnProcessDefinitionId: {}", bpmnProcessDefinitionId);

        Optional<ProcessDefinition> optionalProcessDefinition = processDefinitionRepository.findByBpmnProcessDefinitionId(
            bpmnProcessDefinitionId
        );
        if (!optionalProcessDefinition.isPresent()) {
            throw new BadRequestAlertException("processDefinitionNotFound", bpmnProcessDefinitionId, "processDefinitionNotFound");
        }
        ProcessDefinition processDefinition = optionalProcessDefinition.get();
        ProcessInstance processInstance = new ProcessInstance();
        processInstance.setBusinessKey(businessKey);
        processInstance.setProcessDefinition(processDefinition);
        processInstance.setCamundaProcessDefinitionId(processDefinition.getCamundaProcessDefinitionId());
        processInstance.setCamundaDeploymentId(processDefinition.getCamundaDeploymentId());
        processInstance.setStartDate(LocalDateTime.now());
        processInstance.setStatus(StatusProcessInstance.RUNNING);

        Map<String, Object> params = new HashMap<>();
        params.put(CamundaConstants.PROCESS_INSTANCE, processEntity);
        params.put(CamundaConstants.PROCESS_INSTANCE_INITIALS, processEntity);

        org.camunda.bpm.engine.runtime.ProcessInstance camundaProcessInstance = runtimeService
            .createProcessInstanceById(processDefinition.getCamundaProcessDefinitionId())
            .businessKey(businessKey)
            .setVariables(params)
            .execute();

        processInstance.setCamundaProcessInstanceId(camundaProcessInstance.getProcessInstanceId());
        return processInstanceRepository.save(processInstance);
    }

    /**
     * Save a processInstance.
     *
     * @param processInstanceDTO the entity to save.
     * @return the persisted entity.
     */
    public ProcessInstanceDTO save(ProcessInstanceDTO processInstanceDTO) {
        log.debug("Request to save ProcessInstance : {}", processInstanceDTO);
        ProcessInstance processInstance = processInstanceMapper.toEntity(processInstanceDTO);
        processInstance = processInstanceRepository.save(processInstance);
        return processInstanceMapper.toDto(processInstance);
    }

    /**
     * Get all the processInstances.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ProcessInstanceDTO> findAll() {
        log.debug("Request to get all ProcessInstances");
        return processInstanceRepository
            .findAll()
            .stream()
            .map(processInstanceMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one processInstance by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProcessInstanceDTO> findOne(Long id) {
        log.debug("Request to get ProcessInstance : {}", id);
        return processInstanceRepository.findById(id).map(processInstanceMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<ProcessInstanceDTO> findByCamundaProcessInstanceId(String camundaProcessInstanceId) {
        log.debug("Request to get ProcessInstance by camundaProcessInstanceId: {}", camundaProcessInstanceId);
        return processInstanceRepository.findByCamundaProcessInstanceId(camundaProcessInstanceId).map(processInstanceMapper::toDto);
    }

    public List<ProcessInstanceDTO> findByProcessDefinition(String idOrBpmnProcessDefinitionId) {
        ProcessDefinitionDTO processDefinitionDTO = processDefinitionService.findOne(idOrBpmnProcessDefinitionId).orElseThrow();
        return processInstanceRepository
            .findByProcessDefinitionId(processDefinitionDTO.getId())
            .stream()
            .map(processInstanceMapper::toDto)
            .collect(Collectors.toList());
    }
}
