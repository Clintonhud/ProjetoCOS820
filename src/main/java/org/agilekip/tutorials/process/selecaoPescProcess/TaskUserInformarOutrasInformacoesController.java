package org.agilekip.tutorials.process.selecaoPescProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/selecao-pesc-process/task-user-informar-outras-informacoes")
public class TaskUserInformarOutrasInformacoesController {

    private final Logger log = LoggerFactory.getLogger(TaskUserInformarOutrasInformacoesController.class);

    private final TaskUserInformarOutrasInformacoesService taskUserInformarOutrasInformacoesService;

    public TaskUserInformarOutrasInformacoesController(TaskUserInformarOutrasInformacoesService taskUserInformarOutrasInformacoesService) {
        this.taskUserInformarOutrasInformacoesService = taskUserInformarOutrasInformacoesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskUserInformarOutrasInformacoesContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserInformarOutrasInformacoesContextDTO taskUserInformarOutrasInformacoesContext = taskUserInformarOutrasInformacoesService.loadContext(
            id
        );
        return ResponseEntity.ok(taskUserInformarOutrasInformacoesContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskUserInformarOutrasInformacoesContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserInformarOutrasInformacoesContextDTO taskUserInformarOutrasInformacoesContext = taskUserInformarOutrasInformacoesService.claim(
            id
        );
        return ResponseEntity.ok(taskUserInformarOutrasInformacoesContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(
        @RequestBody TaskUserInformarOutrasInformacoesContextDTO taskUserInformarOutrasInformacoesContext
    ) {
        log.debug(
            "REST request to complete SelecaoPescProcess.TaskUserInformarOutrasInformacoes {}",
            taskUserInformarOutrasInformacoesContext.getTaskInstance().getId()
        );
        taskUserInformarOutrasInformacoesService.complete(taskUserInformarOutrasInformacoesContext);
        return ResponseEntity.noContent().build();
    }
}
