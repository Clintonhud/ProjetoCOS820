import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserInformarFormacaoSuperiorService from './task-user-informar-formacao-superior.service';
import { TaskUserInformarFormacaoSuperiorContext } from './task-user-informar-formacao-superior.model';

const validations: any = {
  taskContext: {
    selecaoPescProcess: {
      selecaoPesc: {
        nomeCompleto: {},
        emailPrincipal: {},
        formacaoInstituicaoNome: {},
        formacaoCursoSuperior: {},
        formacaoInicio: {},
        formacaoTermino: {},
        temExperienciaProfissional: {},
        temDocencia: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskUserInformarFormacaoSuperiorExecuteComponent extends Vue {
  private taskUserInformarFormacaoSuperiorService: TaskUserInformarFormacaoSuperiorService = new TaskUserInformarFormacaoSuperiorService();
  private taskContext: TaskUserInformarFormacaoSuperiorContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskUserInformarFormacaoSuperiorService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskUserInformarFormacaoSuperiorService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
