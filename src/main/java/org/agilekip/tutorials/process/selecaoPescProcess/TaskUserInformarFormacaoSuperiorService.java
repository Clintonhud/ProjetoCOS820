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
public class TaskUserInformarFormacaoSuperiorService {

    private final TaskInstanceService taskInstanceService;

    private final SelecaoPescService selecaoPescService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SelecaoPescProcessRepository selecaoPescProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskUserInformarFormacaoSuperiorMapper taskUserInformarFormacaoSuperiorMapper;

    public TaskUserInformarFormacaoSuperiorService(
        TaskInstanceService taskInstanceService,
        SelecaoPescService selecaoPescService,
        TaskInstanceRepository taskInstanceRepository,
        SelecaoPescProcessRepository selecaoPescProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskUserInformarFormacaoSuperiorMapper taskUserInformarFormacaoSuperiorMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.selecaoPescService = selecaoPescService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.selecaoPescProcessRepository = selecaoPescProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskUserInformarFormacaoSuperiorMapper = taskUserInformarFormacaoSuperiorMapper;
    }

    public TaskUserInformarFormacaoSuperiorContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SelecaoPescProcessDTO selecaoPescProcess = selecaoPescProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskUserInformarFormacaoSuperiorMapper::toSelecaoPescProcessDTO)
            .orElseThrow();

        TaskUserInformarFormacaoSuperiorContextDTO taskUserInformarFormacaoSuperiorContext = new TaskUserInformarFormacaoSuperiorContextDTO();
        taskUserInformarFormacaoSuperiorContext.setTaskInstance(taskInstanceDTO);
        taskUserInformarFormacaoSuperiorContext.setSelecaoPescProcess(selecaoPescProcess);

        return taskUserInformarFormacaoSuperiorContext;
    }

    public TaskUserInformarFormacaoSuperiorContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskUserInformarFormacaoSuperiorContextDTO taskUserInformarFormacaoSuperiorContext) {
        SelecaoPescDTO selecaoPescDTO = selecaoPescService
            .findOne(taskUserInformarFormacaoSuperiorContext.getSelecaoPescProcess().getSelecaoPesc().getId())
            .orElseThrow();
        selecaoPescDTO.setNomeCompleto(taskUserInformarFormacaoSuperiorContext.getSelecaoPescProcess().getSelecaoPesc().getNomeCompleto());
        selecaoPescDTO.setEmailPrincipal(
            taskUserInformarFormacaoSuperiorContext.getSelecaoPescProcess().getSelecaoPesc().getEmailPrincipal()
        );
        selecaoPescDTO.setFormacaoInstituicaoNome(
            taskUserInformarFormacaoSuperiorContext.getSelecaoPescProcess().getSelecaoPesc().getFormacaoInstituicaoNome()
        );
        selecaoPescDTO.setFormacaoCursoSuperior(
            taskUserInformarFormacaoSuperiorContext.getSelecaoPescProcess().getSelecaoPesc().getFormacaoCursoSuperior()
        );
        selecaoPescDTO.setFormacaoInicio(
            taskUserInformarFormacaoSuperiorContext.getSelecaoPescProcess().getSelecaoPesc().getFormacaoInicio()
        );
        selecaoPescDTO.setFormacaoTermino(
            taskUserInformarFormacaoSuperiorContext.getSelecaoPescProcess().getSelecaoPesc().getFormacaoTermino()
        );
        selecaoPescDTO.setTemExperienciaProfissional(
            taskUserInformarFormacaoSuperiorContext.getSelecaoPescProcess().getSelecaoPesc().getTemExperienciaProfissional()
        );
        selecaoPescDTO.setTemDocencia(taskUserInformarFormacaoSuperiorContext.getSelecaoPescProcess().getSelecaoPesc().getTemDocencia());
        selecaoPescService.save(selecaoPescDTO);
    }

    public void complete(TaskUserInformarFormacaoSuperiorContextDTO taskUserInformarFormacaoSuperiorContext) {
        save(taskUserInformarFormacaoSuperiorContext);
        taskInstanceService.complete(
            taskUserInformarFormacaoSuperiorContext.getTaskInstance(),
            taskUserInformarFormacaoSuperiorContext.getSelecaoPescProcess()
        );
    }
}
