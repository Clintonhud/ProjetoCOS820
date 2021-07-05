import { ITaskInstance } from '@/shared/model/task-instance.model';
import { ISelecaoPescProcess } from '@/shared/model/selecao-pesc-process.model';

export class TaskUserRealizarCandidaturaContext {
  taskInstance?: ITaskInstance = {};
  selecaoPescProcess?: ISelecaoPescProcess = {};
}
