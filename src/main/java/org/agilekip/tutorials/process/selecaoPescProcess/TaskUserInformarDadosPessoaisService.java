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
public class TaskUserInformarDadosPessoaisService {

    private final TaskInstanceService taskInstanceService;

    private final SelecaoPescService selecaoPescService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SelecaoPescProcessRepository selecaoPescProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskUserInformarDadosPessoaisMapper taskUserInformarDadosPessoaisMapper;

    public TaskUserInformarDadosPessoaisService(
        TaskInstanceService taskInstanceService,
        SelecaoPescService selecaoPescService,
        TaskInstanceRepository taskInstanceRepository,
        SelecaoPescProcessRepository selecaoPescProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskUserInformarDadosPessoaisMapper taskUserInformarDadosPessoaisMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.selecaoPescService = selecaoPescService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.selecaoPescProcessRepository = selecaoPescProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskUserInformarDadosPessoaisMapper = taskUserInformarDadosPessoaisMapper;
    }

    public TaskUserInformarDadosPessoaisContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SelecaoPescProcessDTO selecaoPescProcess = selecaoPescProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskUserInformarDadosPessoaisMapper::toSelecaoPescProcessDTO)
            .orElseThrow();

        TaskUserInformarDadosPessoaisContextDTO taskUserInformarDadosPessoaisContext = new TaskUserInformarDadosPessoaisContextDTO();
        taskUserInformarDadosPessoaisContext.setTaskInstance(taskInstanceDTO);
        taskUserInformarDadosPessoaisContext.setSelecaoPescProcess(selecaoPescProcess);

        return taskUserInformarDadosPessoaisContext;
    }

    public TaskUserInformarDadosPessoaisContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskUserInformarDadosPessoaisContextDTO taskUserInformarDadosPessoaisContext) {
        SelecaoPescDTO selecaoPescDTO = selecaoPescService
            .findOne(taskUserInformarDadosPessoaisContext.getSelecaoPescProcess().getSelecaoPesc().getId())
            .orElseThrow();
        selecaoPescDTO.setNomeCompleto(taskUserInformarDadosPessoaisContext.getSelecaoPescProcess().getSelecaoPesc().getNomeCompleto());
        selecaoPescDTO.setEmailPrincipal(taskUserInformarDadosPessoaisContext.getSelecaoPescProcess().getSelecaoPesc().getEmailPrincipal());
        selecaoPescDTO.setDataNascimento(taskUserInformarDadosPessoaisContext.getSelecaoPescProcess().getSelecaoPesc().getDataNascimento());
        selecaoPescDTO.setCidadeNascimento(
            taskUserInformarDadosPessoaisContext.getSelecaoPescProcess().getSelecaoPesc().getCidadeNascimento()
        );
        selecaoPescService.save(selecaoPescDTO);
    }

    public void complete(TaskUserInformarDadosPessoaisContextDTO taskUserInformarDadosPessoaisContext) {
        save(taskUserInformarDadosPessoaisContext);
        taskInstanceService.complete(
            taskUserInformarDadosPessoaisContext.getTaskInstance(),
            taskUserInformarDadosPessoaisContext.getSelecaoPescProcess()
        );
    }
}
