import { Component, Vue, Inject } from 'vue-property-decorator';
import { IProcessDefinition } from '@/shared/model/process-definition.model';
import { ISelecaoPescProcess } from '@/shared/model/selecao-pesc-process.model';

import ProcessDefinitionService from '@/entities/process-definition/process-definition.service';
import SelecaoPescProcessService from './selecao-pesc-process.service';

@Component
export default class SelecaoPescProcessListComponent extends Vue {
  @Inject('processDefinitionService') private processDefinitionService: () => ProcessDefinitionService;
  @Inject('selecaoPescProcessService') private selecaoPescProcessService: () => SelecaoPescProcessService;

  public bpmnProcessDefinitionId: string = 'SelecaoPescProcess';
  public processDefinition: IProcessDefinition = {};
  public selecaoPescProcessList: ISelecaoPescProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService()
      .find(this.bpmnProcessDefinitionId)
      .then(
        res => {
          this.processDefinition = res;
          this.isFetchingProcessDefinition = false;
        },
        err => {
          this.isFetchingProcessDefinition = false;
        }
      );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.selecaoPescProcessService()
      .retrieve()
      .then(
        res => {
          this.selecaoPescProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
