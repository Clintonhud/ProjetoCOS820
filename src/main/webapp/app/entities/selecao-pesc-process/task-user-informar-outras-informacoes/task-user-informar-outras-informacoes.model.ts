import { ITaskInstance } from '@/shared/model/task-instance.model';
import { ISelecaoPescProcess } from '@/shared/model/selecao-pesc-process.model';

export class TaskUserInformarOutrasInformacoesContext {
  taskInstance?: ITaskInstance = {};
  selecaoPescProcess?: ISelecaoPescProcess = {};
}
