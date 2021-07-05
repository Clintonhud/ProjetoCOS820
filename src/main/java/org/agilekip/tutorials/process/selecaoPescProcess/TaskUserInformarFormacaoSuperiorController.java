package org.agilekip.tutorials.process.selecaoPescProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/selecao-pesc-process/task-user-informar-formacao-superior")
public class TaskUserInformarFormacaoSuperiorController {

    private final Logger log = LoggerFactory.getLogger(TaskUserInformarFormacaoSuperiorController.class);

    private final TaskUserInformarFormacaoSuperiorService taskUserInformarFormacaoSuperiorService;

    public TaskUserInformarFormacaoSuperiorController(TaskUserInformarFormacaoSuperiorService taskUserInformarFormacaoSuperiorService) {
        this.taskUserInformarFormacaoSuperiorService = taskUserInformarFormacaoSuperiorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskUserInformarFormacaoSuperiorContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserInformarFormacaoSuperiorContextDTO taskUserInformarFormacaoSuperiorContext = taskUserInformarFormacaoSuperiorService.loadContext(
            id
        );
        return ResponseEntity.ok(taskUserInformarFormacaoSuperiorContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskUserInformarFormacaoSuperiorContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserInformarFormacaoSuperiorContextDTO taskUserInformarFormacaoSuperiorContext = taskUserInformarFormacaoSuperiorService.claim(
            id
        );
        return ResponseEntity.ok(taskUserInformarFormacaoSuperiorContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskUserInformarFormacaoSuperiorContextDTO taskUserInformarFormacaoSuperiorContext) {
        log.debug(
            "REST request to complete SelecaoPescProcess.TaskUserInformarFormacaoSuperior {}",
            taskUserInformarFormacaoSuperiorContext.getTaskInstance().getId()
        );
        taskUserInformarFormacaoSuperiorService.complete(taskUserInformarFormacaoSuperiorContext);
        return ResponseEntity.noContent().build();
    }
}
