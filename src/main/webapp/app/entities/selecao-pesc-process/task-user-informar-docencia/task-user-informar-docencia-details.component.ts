import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserInformarDocenciaService from './task-user-informar-docencia.service';
import { TaskUserInformarDocenciaContext } from './task-user-informar-docencia.model';

@Component
export default class TaskUserInformarDocenciaDetailsComponent extends Vue {
  private taskUserInformarDocenciaService: TaskUserInformarDocenciaService = new TaskUserInformarDocenciaService();
  private taskContext: TaskUserInformarDocenciaContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskUserInformarDocenciaService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
