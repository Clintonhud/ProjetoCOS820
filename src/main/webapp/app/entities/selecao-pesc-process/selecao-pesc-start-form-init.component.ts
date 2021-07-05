import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISelecaoPescProcess, SelecaoPescProcess } from '@/shared/model/selecao-pesc-process.model';
import { ProcessInstance } from '@/shared/model/process-instance.model';
import { SelecaoPesc } from '@/shared/model/selecao-pesc.model';

import SelecaoPescProcessService from './selecao-pesc-process.service';
import ProcessDefinitionService from '@/entities/process-definition/process-definition.service';

const validations: any = {
  selecaoPescProcess: {
    selecaoPesc: {
      nomeCompleto: {},
      emailPrincipal: {},
      nacionalidade: {},
      documentoCpfPassaporte: {},
    },
  },
};

@Component({
  validations,
})
export default class SelecaoPescStartFormInitComponent extends Vue {
  @Inject('selecaoPescProcessService') private selecaoPescProcessService: () => SelecaoPescProcessService;
  @Inject('processDefinitionService') private processDefinitionService: () => ProcessDefinitionService;

  public bpmnProcessDefinitionId: string = 'SelecaoPescProcess';
  public selecaoPescProcess: ISelecaoPescProcess = new SelecaoPescProcess();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initSelecaoPescStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.selecaoPescProcessService()
      .create(this.selecaoPescProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('selecaoPescApp.selecaoPescStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initSelecaoPescStartForm(): void {
    this.selecaoPescProcess.selecaoPesc = new SelecaoPesc();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService()
      .find(this.bpmnProcessDefinitionId)
      .then(res => {
        this.selecaoPescProcess.processInstance = new ProcessInstance();
        this.selecaoPescProcess.processInstance.processDefinition = res;
      });
  }
}
