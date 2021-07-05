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
public class TaskUserInformarOutrasInformacoesService {

    private final TaskInstanceService taskInstanceService;

    private final SelecaoPescService selecaoPescService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SelecaoPescProcessRepository selecaoPescProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskUserInformarOutrasInformacoesMapper taskUserInformarOutrasInformacoesMapper;

    public TaskUserInformarOutrasInformacoesService(
        TaskInstanceService taskInstanceService,
        SelecaoPescService selecaoPescService,
        TaskInstanceRepository taskInstanceRepository,
        SelecaoPescProcessRepository selecaoPescProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskUserInformarOutrasInformacoesMapper taskUserInformarOutrasInformacoesMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.selecaoPescService = selecaoPescService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.selecaoPescProcessRepository = selecaoPescProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskUserInformarOutrasInformacoesMapper = taskUserInformarOutrasInformacoesMapper;
    }

    public TaskUserInformarOutrasInformacoesContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SelecaoPescProcessDTO selecaoPescProcess = selecaoPescProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskUserInformarOutrasInformacoesMapper::toSelecaoPescProcessDTO)
            .orElseThrow();

        TaskUserInformarOutrasInformacoesContextDTO taskUserInformarOutrasInformacoesContext = new TaskUserInformarOutrasInformacoesContextDTO();
        taskUserInformarOutrasInformacoesContext.setTaskInstance(taskInstanceDTO);
        taskUserInformarOutrasInformacoesContext.setSelecaoPescProcess(selecaoPescProcess);

        return taskUserInformarOutrasInformacoesContext;
    }

    public TaskUserInformarOutrasInformacoesContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskUserInformarOutrasInformacoesContextDTO taskUserInformarOutrasInformacoesContext) {
        SelecaoPescDTO selecaoPescDTO = selecaoPescService
            .findOne(taskUserInformarOutrasInformacoesContext.getSelecaoPescProcess().getSelecaoPesc().getId())
            .orElseThrow();
        selecaoPescDTO.setNomeCompleto(taskUserInformarOutrasInformacoesContext.getSelecaoPescProcess().getSelecaoPesc().getNomeCompleto());
        selecaoPescDTO.setEmailPrincipal(
            taskUserInformarOutrasInformacoesContext.getSelecaoPescProcess().getSelecaoPesc().getEmailPrincipal()
        );
        selecaoPescDTO.setProficienciaInglesTipoTeste(
            taskUserInformarOutrasInformacoesContext.getSelecaoPescProcess().getSelecaoPesc().getProficienciaInglesTipoTeste()
        );
        selecaoPescDTO.setProficienciaInglesNota(
            taskUserInformarOutrasInformacoesContext.getSelecaoPescProcess().getSelecaoPesc().getProficienciaInglesNota()
        );
        selecaoPescService.save(selecaoPescDTO);
    }

    public void complete(TaskUserInformarOutrasInformacoesContextDTO taskUserInformarOutrasInformacoesContext) {
        save(taskUserInformarOutrasInformacoesContext);
        taskInstanceService.complete(
            taskUserInformarOutrasInformacoesContext.getTaskInstance(),
            taskUserInformarOutrasInformacoesContext.getSelecaoPescProcess()
        );
    }
}
