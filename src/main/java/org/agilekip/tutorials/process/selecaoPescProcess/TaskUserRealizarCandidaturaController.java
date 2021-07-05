package org.agilekip.tutorials.process.selecaoPescProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/selecao-pesc-process/task-user-realizar-candidatura")
public class TaskUserRealizarCandidaturaController {

    private final Logger log = LoggerFactory.getLogger(TaskUserRealizarCandidaturaController.class);

    private final TaskUserRealizarCandidaturaService taskUserRealizarCandidaturaService;

    public TaskUserRealizarCandidaturaController(TaskUserRealizarCandidaturaService taskUserRealizarCandidaturaService) {
        this.taskUserRealizarCandidaturaService = taskUserRealizarCandidaturaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskUserRealizarCandidaturaContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserRealizarCandidaturaContextDTO taskUserRealizarCandidaturaContext = taskUserRealizarCandidaturaService.loadContext(id);
        return ResponseEntity.ok(taskUserRealizarCandidaturaContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskUserRealizarCandidaturaContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserRealizarCandidaturaContextDTO taskUserRealizarCandidaturaContext = taskUserRealizarCandidaturaService.claim(id);
        return ResponseEntity.ok(taskUserRealizarCandidaturaContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskUserRealizarCandidaturaContextDTO taskUserRealizarCandidaturaContext) {
        log.debug(
            "REST request to complete SelecaoPescProcess.TaskUserRealizarCandidatura {}",
            taskUserRealizarCandidaturaContext.getTaskInstance().getId()
        );
        taskUserRealizarCandidaturaService.complete(taskUserRealizarCandidaturaContext);
        return ResponseEntity.noContent().build();
    }
}
