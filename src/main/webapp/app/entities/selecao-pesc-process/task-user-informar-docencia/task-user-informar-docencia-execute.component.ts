import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserInformarDocenciaService from './task-user-informar-docencia.service';
import { TaskUserInformarDocenciaContext } from './task-user-informar-docencia.model';

const validations: any = {
  taskContext: {
    selecaoPescProcess: {
      selecaoPesc: {
        nomeCompleto: {},
        emailPrincipal: {},
        docenciaInstituicaoNome: {},
        docenciaInstituicaoPais: {},
        docenciaNomeDisciplina: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskUserInformarDocenciaExecuteComponent extends Vue {
  private taskUserInformarDocenciaService: TaskUserInformarDocenciaService = new TaskUserInformarDocenciaService();
  private taskContext: TaskUserInformarDocenciaContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskUserInformarDocenciaService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskUserInformarDocenciaService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
