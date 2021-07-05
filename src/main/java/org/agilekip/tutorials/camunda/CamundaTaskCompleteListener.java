package org.agilekip.tutorials.camunda;

import java.time.Instant;
import java.util.Optional;
import org.agilekip.tutorials.domain.TaskInstance;
import org.agilekip.tutorials.domain.enumeration.StatusTaskInstance;
import org.agilekip.tutorials.repository.TaskInstanceRepository;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component
public class CamundaTaskCompleteListener implements TaskListener {

    private final TaskInstanceRepository taskInstanceRepository;

    public CamundaTaskCompleteListener(TaskInstanceRepository taskInstanceRepository) {
        this.taskInstanceRepository = taskInstanceRepository;
    }

    public void notify(DelegateTask delegateTask) {
        Optional<TaskInstance> optionalTaskInstance = taskInstanceRepository.findByTaskId(delegateTask.getId());

        if (optionalTaskInstance.isPresent()) {
            TaskInstance taskInstance = optionalTaskInstance.get();
            taskInstance.setStatus(StatusTaskInstance.COMPLETED);
            taskInstance.endTime(Instant.now());
            taskInstanceRepository.save(taskInstance);
        }
    }
}
