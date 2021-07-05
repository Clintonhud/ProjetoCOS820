package org.agilekip.tutorials.process.selecaoPescProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/selecao-pesc-process/task-user-informar-experiencia-profissional")
public class TaskUserInformarExperienciaProfissionalController {

    private final Logger log = LoggerFactory.getLogger(TaskUserInformarExperienciaProfissionalController.class);

    private final TaskUserInformarExperienciaProfissionalService taskUserInformarExperienciaProfissionalService;

    public TaskUserInformarExperienciaProfissionalController(
        TaskUserInformarExperienciaProfissionalService taskUserInformarExperienciaProfissionalService
    ) {
        this.taskUserInformarExperienciaProfissionalService = taskUserInformarExperienciaProfissionalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskUserInformarExperienciaProfissionalContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserInformarExperienciaProfissionalContextDTO taskUserInformarExperienciaProfissionalContext = taskUserInformarExperienciaProfissionalService.loadContext(
            id
        );
        return ResponseEntity.ok(taskUserInformarExperienciaProfissionalContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskUserInformarExperienciaProfissionalContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserInformarExperienciaProfissionalContextDTO taskUserInformarExperienciaProfissionalContext = taskUserInformarExperienciaProfissionalService.claim(
            id
        );
        return ResponseEntity.ok(taskUserInformarExperienciaProfissionalContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(
        @RequestBody TaskUserInformarExperienciaProfissionalContextDTO taskUserInformarExperienciaProfissionalContext
    ) {
        log.debug(
            "REST request to complete SelecaoPescProcess.TaskUserInformarExperienciaProfissional {}",
            taskUserInformarExperienciaProfissionalContext.getTaskInstance().getId()
        );
        taskUserInformarExperienciaProfissionalService.complete(taskUserInformarExperienciaProfissionalContext);
        return ResponseEntity.noContent().build();
    }
}
