package org.agilekip.tutorials.process.selecaoPescProcess;

import org.agilekip.tutorials.repository.SelecaoPescProcessRepository;
import org.agilekip.tutorials.repository.TaskInstanceRepository;
import org.agilekip.tutorials.service.SelecaoPescService;
import org.agilekip.tutorials.service.TaskInstanceService;
import org.agilekip.tutorials.service.dto.SelecaoPescDTO;
import org.agilekip.tutorials.service.dto.SelecaoPescProcessDTO;
import org.agilekip.tutorials.service.dto.TaskInstanceDTO;
import org.agilekip.tutorials.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskUserRealizarCandidaturaService {

    private final TaskInstanceService taskInstanceService;

    private final SelecaoPescService selecaoPescService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SelecaoPescProcessRepository selecaoPescProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskUserRealizarCandidaturaMapper taskUserRealizarCandidaturaMapper;

    public TaskUserRealizarCandidaturaService(
        TaskInstanceService taskInstanceService,
        SelecaoPescService selecaoPescService,
        TaskInstanceRepository taskInstanceRepository,
        SelecaoPescProcessRepository selecaoPescProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskUserRealizarCandidaturaMapper taskUserRealizarCandidaturaMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.selecaoPescService = selecaoPescService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.selecaoPescProcessRepository = selecaoPescProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskUserRealizarCandidaturaMapper = taskUserRealizarCandidaturaMapper;
    }

    public TaskUserRealizarCandidaturaContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SelecaoPescProcessDTO selecaoPescProcess = selecaoPescProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskUserRealizarCandidaturaMapper::toSelecaoPescProcessDTO)
            .orElseThrow();

        TaskUserRealizarCandidaturaContextDTO taskUserRealizarCandidaturaContext = new TaskUserRealizarCandidaturaContextDTO();
        taskUserRealizarCandidaturaContext.setTaskInstance(taskInstanceDTO);
        taskUserRealizarCandidaturaContext.setSelecaoPescProcess(selecaoPescProcess);

        return taskUserRealizarCandidaturaContext;
    }

    public TaskUserRealizarCandidaturaContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskUserRealizarCandidaturaContextDTO taskUserRealizarCandidaturaContext) {
        SelecaoPescDTO selecaoPescDTO = selecaoPescService
            .findOne(taskUserRealizarCandidaturaContext.getSelecaoPescProcess().getSelecaoPesc().getId())
            .orElseThrow();
        selecaoPescDTO.setNomeCompleto(taskUserRealizarCandidaturaContext.getSelecaoPescProcess().getSelecaoPesc().getNomeCompleto());
        selecaoPescDTO.setEmailPrincipal(taskUserRealizarCandidaturaContext.getSelecaoPescProcess().getSelecaoPesc().getEmailPrincipal());
        selecaoPescDTO.setMestradoDoutorado(
            taskUserRealizarCandidaturaContext.getSelecaoPescProcess().getSelecaoPesc().getMestradoDoutorado()
        );
        selecaoPescDTO.setLinhaAreaInteresse(
            taskUserRealizarCandidaturaContext.getSelecaoPescProcess().getSelecaoPesc().getLinhaAreaInteresse()
        );
        selecaoPescService.save(selecaoPescDTO);
    }

    public void complete(TaskUserRealizarCandidaturaContextDTO taskUserRealizarCandidaturaContext) {
        save(taskUserRealizarCandidaturaContext);
        taskInstanceService.complete(
            taskUserRealizarCandidaturaContext.getTaskInstance(),
            taskUserRealizarCandidaturaContext.getSelecaoPescProcess()
        );
    }
}
