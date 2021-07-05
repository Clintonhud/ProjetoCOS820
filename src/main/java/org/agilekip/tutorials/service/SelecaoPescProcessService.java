package org.agilekip.tutorials.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.agilekip.tutorials.domain.ProcessInstance;
import org.agilekip.tutorials.domain.SelecaoPescProcess;
import org.agilekip.tutorials.repository.SelecaoPescProcessRepository;
import org.agilekip.tutorials.repository.SelecaoPescRepository;
import org.agilekip.tutorials.service.dto.SelecaoPescProcessDTO;
import org.agilekip.tutorials.service.mapper.SelecaoPescProcessMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link SelecaoPescProcess}.
 */
@Service
@Transactional
public class SelecaoPescProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "SelecaoPescProcess";

    private final Logger log = LoggerFactory.getLogger(SelecaoPescProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final SelecaoPescRepository selecaoPescRepository;

    private final SelecaoPescProcessRepository selecaoPescProcessRepository;

    private final SelecaoPescProcessMapper selecaoPescProcessMapper;

    public SelecaoPescProcessService(
        ProcessInstanceService processInstanceService,
        SelecaoPescRepository selecaoPescRepository,
        SelecaoPescProcessRepository selecaoPescProcessRepository,
        SelecaoPescProcessMapper selecaoPescProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.selecaoPescRepository = selecaoPescRepository;
        this.selecaoPescProcessRepository = selecaoPescProcessRepository;
        this.selecaoPescProcessMapper = selecaoPescProcessMapper;
    }

    /**
     * Save a selecaoPescProcess.
     *
     * @param selecaoPescProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public SelecaoPescProcessDTO create(SelecaoPescProcessDTO selecaoPescProcessDTO) {
        log.debug("Request to save SelecaoPescProcess : {}", selecaoPescProcessDTO);

        SelecaoPescProcess selecaoPescProcess = selecaoPescProcessMapper.toEntity(selecaoPescProcessDTO);

        //Saving the domainEntity
        selecaoPescRepository.save(selecaoPescProcess.getSelecaoPesc());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "SelecaoPesc#" + selecaoPescProcess.getSelecaoPesc().getId(),
            selecaoPescProcess
        );
        selecaoPescProcess.setProcessInstance(processInstance);

        //Saving the process entity
        selecaoPescProcess = selecaoPescProcessRepository.save(selecaoPescProcess);
        return selecaoPescProcessMapper.toDto(selecaoPescProcess);
    }

    /**
     * Get all the selecaoPescProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<SelecaoPescProcessDTO> findAll() {
        log.debug("Request to get all SelecaoPescProcesss");
        return selecaoPescProcessRepository
            .findAll()
            .stream()
            .map(selecaoPescProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one selecaoPescProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SelecaoPescProcessDTO> findOne(Long id) {
        log.debug("Request to get SelecaoPescProcess : {}", id);
        return selecaoPescProcessRepository.findById(id).map(selecaoPescProcessMapper::toDto);
    }

    /**
     * Get one selecaoPescProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SelecaoPescProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get SelecaoPescProcess by  processInstanceId: {}", processInstanceId);
        return selecaoPescProcessRepository.findByProcessInstanceId(processInstanceId).map(selecaoPescProcessMapper::toDto);
    }
}
