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
public class TaskUserInformarExperienciaProfissionalService {

    private final TaskInstanceService taskInstanceService;

    private final SelecaoPescService selecaoPescService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SelecaoPescProcessRepository selecaoPescProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskUserInformarExperienciaProfissionalMapper taskUserInformarExperienciaProfissionalMapper;

    public TaskUserInformarExperienciaProfissionalService(
        TaskInstanceService taskInstanceService,
        SelecaoPescService selecaoPescService,
        TaskInstanceRepository taskInstanceRepository,
        SelecaoPescProcessRepository selecaoPescProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskUserInformarExperienciaProfissionalMapper taskUserInformarExperienciaProfissionalMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.selecaoPescService = selecaoPescService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.selecaoPescProcessRepository = selecaoPescProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskUserInformarExperienciaProfissionalMapper = taskUserInformarExperienciaProfissionalMapper;
    }

    public TaskUserInformarExperienciaProfissionalContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SelecaoPescProcessDTO selecaoPescProcess = selecaoPescProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskUserInformarExperienciaProfissionalMapper::toSelecaoPescProcessDTO)
            .orElseThrow();

        TaskUserInformarExperienciaProfissionalContextDTO taskUserInformarExperienciaProfissionalContext = new TaskUserInformarExperienciaProfissionalContextDTO();
        taskUserInformarExperienciaProfissionalContext.setTaskInstance(taskInstanceDTO);
        taskUserInformarExperienciaProfissionalContext.setSelecaoPescProcess(selecaoPescProcess);

        return taskUserInformarExperienciaProfissionalContext;
    }

    public TaskUserInformarExperienciaProfissionalContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskUserInformarExperienciaProfissionalContextDTO taskUserInformarExperienciaProfissionalContext) {
        SelecaoPescDTO selecaoPescDTO = selecaoPescService
            .findOne(taskUserInformarExperienciaProfissionalContext.getSelecaoPescProcess().getSelecaoPesc().getId())
            .orElseThrow();
        selecaoPescDTO.setNomeCompleto(
            taskUserInformarExperienciaProfissionalContext.getSelecaoPescProcess().getSelecaoPesc().getNomeCompleto()
        );
        selecaoPescDTO.setEmailPrincipal(
            taskUserInformarExperienciaProfissionalContext.getSelecaoPescProcess().getSelecaoPesc().getEmailPrincipal()
        );
        selecaoPescDTO.setEmpresaNome(
            taskUserInformarExperienciaProfissionalContext.getSelecaoPescProcess().getSelecaoPesc().getEmpresaNome()
        );
        selecaoPescDTO.setEmpresaUrlSite(
            taskUserInformarExperienciaProfissionalContext.getSelecaoPescProcess().getSelecaoPesc().getEmpresaUrlSite()
        );
        selecaoPescDTO.setEmpresaFuncao(
            taskUserInformarExperienciaProfissionalContext.getSelecaoPescProcess().getSelecaoPesc().getEmpresaFuncao()
        );
        selecaoPescService.save(selecaoPescDTO);
    }

    public void complete(TaskUserInformarExperienciaProfissionalContextDTO taskUserInformarExperienciaProfissionalContext) {
        save(taskUserInformarExperienciaProfissionalContext);
        taskInstanceService.complete(
            taskUserInformarExperienciaProfissionalContext.getTaskInstance(),
            taskUserInformarExperienciaProfissionalContext.getSelecaoPescProcess()
        );
    }
}
