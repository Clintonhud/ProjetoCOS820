import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserInformarExperienciaProfissionalService from './task-user-informar-experiencia-profissional.service';
import { TaskUserInformarExperienciaProfissionalContext } from './task-user-informar-experiencia-profissional.model';

const validations: any = {
  taskContext: {
    selecaoPescProcess: {
      selecaoPesc: {
        nomeCompleto: {},
        emailPrincipal: {},
        empresaNome: {},
        empresaUrlSite: {},
        empresaFuncao: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskUserInformarExperienciaProfissionalExecuteComponent extends Vue {
  private taskUserInformarExperienciaProfissionalService: TaskUserInformarExperienciaProfissionalService = new TaskUserInformarExperienciaProfissionalService();
  private taskContext: TaskUserInformarExperienciaProfissionalContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskUserInformarExperienciaProfissionalService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskUserInformarExperienciaProfissionalService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
