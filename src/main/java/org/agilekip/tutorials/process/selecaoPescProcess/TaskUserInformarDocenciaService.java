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
public class TaskUserInformarDocenciaService {

    private final TaskInstanceService taskInstanceService;

    private final SelecaoPescService selecaoPescService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SelecaoPescProcessRepository selecaoPescProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskUserInformarDocenciaMapper taskUserInformarDocenciaMapper;

    public TaskUserInformarDocenciaService(
        TaskInstanceService taskInstanceService,
        SelecaoPescService selecaoPescService,
        TaskInstanceRepository taskInstanceRepository,
        SelecaoPescProcessRepository selecaoPescProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskUserInformarDocenciaMapper taskUserInformarDocenciaMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.selecaoPescService = selecaoPescService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.selecaoPescProcessRepository = selecaoPescProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskUserInformarDocenciaMapper = taskUserInformarDocenciaMapper;
    }

    public TaskUserInformarDocenciaContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SelecaoPescProcessDTO selecaoPescProcess = selecaoPescProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskUserInformarDocenciaMapper::toSelecaoPescProcessDTO)
            .orElseThrow();

        TaskUserInformarDocenciaContextDTO taskUserInformarDocenciaContext = new TaskUserInformarDocenciaContextDTO();
        taskUserInformarDocenciaContext.setTaskInstance(taskInstanceDTO);
        taskUserInformarDocenciaContext.setSelecaoPescProcess(selecaoPescProcess);

        return taskUserInformarDocenciaContext;
    }

    public TaskUserInformarDocenciaContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskUserInformarDocenciaContextDTO taskUserInformarDocenciaContext) {
        SelecaoPescDTO selecaoPescDTO = selecaoPescService
            .findOne(taskUserInformarDocenciaContext.getSelecaoPescProcess().getSelecaoPesc().getId())
            .orElseThrow();
        selecaoPescDTO.setNomeCompleto(taskUserInformarDocenciaContext.getSelecaoPescProcess().getSelecaoPesc().getNomeCompleto());
        selecaoPescDTO.setEmailPrincipal(taskUserInformarDocenciaContext.getSelecaoPescProcess().getSelecaoPesc().getEmailPrincipal());
        selecaoPescDTO.setDocenciaInstituicaoNome(
            taskUserInformarDocenciaContext.getSelecaoPescProcess().getSelecaoPesc().getDocenciaInstituicaoNome()
        );
        selecaoPescDTO.setDocenciaInstituicaoPais(
            taskUserInformarDocenciaContext.getSelecaoPescProcess().getSelecaoPesc().getDocenciaInstituicaoPais()
        );
        selecaoPescDTO.setDocenciaNomeDisciplina(
            taskUserInformarDocenciaContext.getSelecaoPescProcess().getSelecaoPesc().getDocenciaNomeDisciplina()
        );
        selecaoPescService.save(selecaoPescDTO);
    }

    public void complete(TaskUserInformarDocenciaContextDTO taskUserInformarDocenciaContext) {
        save(taskUserInformarDocenciaContext);
        taskInstanceService.complete(
            taskUserInformarDocenciaContext.getTaskInstance(),
            taskUserInformarDocenciaContext.getSelecaoPescProcess()
        );
    }
}
