import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserInformarDadosPessoaisService from './task-user-informar-dados-pessoais.service';
import { TaskUserInformarDadosPessoaisContext } from './task-user-informar-dados-pessoais.model';

const validations: any = {
  taskContext: {
    selecaoPescProcess: {
      selecaoPesc: {
        nomeCompleto: {},
        emailPrincipal: {},
        dataNascimento: {},
        cidadeNascimento: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskUserInformarDadosPessoaisExecuteComponent extends Vue {
  private taskUserInformarDadosPessoaisService: TaskUserInformarDadosPessoaisService = new TaskUserInformarDadosPessoaisService();
  private taskContext: TaskUserInformarDadosPessoaisContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskUserInformarDadosPessoaisService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskUserInformarDadosPessoaisService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
