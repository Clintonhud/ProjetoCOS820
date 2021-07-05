package org.agilekip.tutorials.process.selecaoPescProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/selecao-pesc-process/task-user-informar-dados-pessoais")
public class TaskUserInformarDadosPessoaisController {

    private final Logger log = LoggerFactory.getLogger(TaskUserInformarDadosPessoaisController.class);

    private final TaskUserInformarDadosPessoaisService taskUserInformarDadosPessoaisService;

    public TaskUserInformarDadosPessoaisController(TaskUserInformarDadosPessoaisService taskUserInformarDadosPessoaisService) {
        this.taskUserInformarDadosPessoaisService = taskUserInformarDadosPessoaisService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskUserInformarDadosPessoaisContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserInformarDadosPessoaisContextDTO taskUserInformarDadosPessoaisContext = taskUserInformarDadosPessoaisService.loadContext(id);
        return ResponseEntity.ok(taskUserInformarDadosPessoaisContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskUserInformarDadosPessoaisContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserInformarDadosPessoaisContextDTO taskUserInformarDadosPessoaisContext = taskUserInformarDadosPessoaisService.claim(id);
        return ResponseEntity.ok(taskUserInformarDadosPessoaisContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskUserInformarDadosPessoaisContextDTO taskUserInformarDadosPessoaisContext) {
        log.debug(
            "REST request to complete SelecaoPescProcess.TaskUserInformarDadosPessoais {}",
            taskUserInformarDadosPessoaisContext.getTaskInstance().getId()
        );
        taskUserInformarDadosPessoaisService.complete(taskUserInformarDadosPessoaisContext);
        return ResponseEntity.noContent().build();
    }
}
