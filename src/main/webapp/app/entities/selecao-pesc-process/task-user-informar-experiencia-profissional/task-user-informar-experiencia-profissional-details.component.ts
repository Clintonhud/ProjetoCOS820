import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserInformarExperienciaProfissionalService from './task-user-informar-experiencia-profissional.service';
import { TaskUserInformarExperienciaProfissionalContext } from './task-user-informar-experiencia-profissional.model';

@Component
export default class TaskUserInformarExperienciaProfissionalDetailsComponent extends Vue {
  private taskUserInformarExperienciaProfissionalService: TaskUserInformarExperienciaProfissionalService = new TaskUserInformarExperienciaProfissionalService();
  private taskContext: TaskUserInformarExperienciaProfissionalContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskUserInformarExperienciaProfissionalService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
