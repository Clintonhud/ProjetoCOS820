import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserRealizarCandidaturaService from './task-user-realizar-candidatura.service';
import { TaskUserRealizarCandidaturaContext } from './task-user-realizar-candidatura.model';

const validations: any = {
  taskContext: {
    selecaoPescProcess: {
      selecaoPesc: {
        nomeCompleto: {},
        emailPrincipal: {},
        mestradoDoutorado: {},
        linhaAreaInteresse: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskUserRealizarCandidaturaExecuteComponent extends Vue {
  private taskUserRealizarCandidaturaService: TaskUserRealizarCandidaturaService = new TaskUserRealizarCandidaturaService();
  private taskContext: TaskUserRealizarCandidaturaContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskUserRealizarCandidaturaService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskUserRealizarCandidaturaService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
