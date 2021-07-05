package org.agilekip.tutorials.process.selecaoPescProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/selecao-pesc-process/task-user-informar-docencia")
public class TaskUserInformarDocenciaController {

    private final Logger log = LoggerFactory.getLogger(TaskUserInformarDocenciaController.class);

    private final TaskUserInformarDocenciaService taskUserInformarDocenciaService;

    public TaskUserInformarDocenciaController(TaskUserInformarDocenciaService taskUserInformarDocenciaService) {
        this.taskUserInformarDocenciaService = taskUserInformarDocenciaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskUserInformarDocenciaContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserInformarDocenciaContextDTO taskUserInformarDocenciaContext = taskUserInformarDocenciaService.loadContext(id);
        return ResponseEntity.ok(taskUserInformarDocenciaContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskUserInformarDocenciaContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserInformarDocenciaContextDTO taskUserInformarDocenciaContext = taskUserInformarDocenciaService.claim(id);
        return ResponseEntity.ok(taskUserInformarDocenciaContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskUserInformarDocenciaContextDTO taskUserInformarDocenciaContext) {
        log.debug(
            "REST request to complete SelecaoPescProcess.TaskUserInformarDocencia {}",
            taskUserInformarDocenciaContext.getTaskInstance().getId()
        );
        taskUserInformarDocenciaService.complete(taskUserInformarDocenciaContext);
        return ResponseEntity.noContent().build();
    }
}
