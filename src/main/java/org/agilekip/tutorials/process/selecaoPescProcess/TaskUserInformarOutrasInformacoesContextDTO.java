package org.agilekip.tutorials.process.selecaoPescProcess;

import org.agilekip.tutorials.service.dto.SelecaoPescProcessDTO;
import org.agilekip.tutorials.service.dto.TaskInstanceDTO;

public class TaskUserInformarOutrasInformacoesContextDTO {

    private SelecaoPescProcessDTO selecaoPescProcess;
    private TaskInstanceDTO taskInstance;

    public SelecaoPescProcessDTO getSelecaoPescProcess() {
        return selecaoPescProcess;
    }

    public void setSelecaoPescProcess(SelecaoPescProcessDTO selecaoPescProcess) {
        this.selecaoPescProcess = selecaoPescProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
