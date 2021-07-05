import { IProcessInstance } from '@/shared/model/process-instance.model';
import { ISelecaoPesc } from '@/shared/model/selecao-pesc.model';

export interface ISelecaoPescProcess {
  id?: number;
  processInstance?: IProcessInstance | null;
  selecaoPesc?: ISelecaoPesc | null;
}

export class SelecaoPescProcess implements ISelecaoPescProcess {
  constructor(public id?: number, public processInstance?: IProcessInstance | null, public selecaoPesc?: ISelecaoPesc | null) {}
}
