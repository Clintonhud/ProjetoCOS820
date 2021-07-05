import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserInformarOutrasInformacoesService from './task-user-informar-outras-informacoes.service';
import { TaskUserInformarOutrasInformacoesContext } from './task-user-informar-outras-informacoes.model';

const validations: any = {
  taskContext: {
    selecaoPescProcess: {
      selecaoPesc: {
        nomeCompleto: {},
        emailPrincipal: {},
        proficienciaInglesTipoTeste: {},
        proficienciaInglesNota: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskUserInformarOutrasInformacoesExecuteComponent extends Vue {
  private taskUserInformarOutrasInformacoesService: TaskUserInformarOutrasInformacoesService = new TaskUserInformarOutrasInformacoesService();
  private taskContext: TaskUserInformarOutrasInformacoesContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskUserInformarOutrasInformacoesService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskUserInformarOutrasInformacoesService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
