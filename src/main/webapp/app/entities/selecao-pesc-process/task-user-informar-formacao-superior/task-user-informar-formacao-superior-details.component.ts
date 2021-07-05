import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserInformarFormacaoSuperiorService from './task-user-informar-formacao-superior.service';
import { TaskUserInformarFormacaoSuperiorContext } from './task-user-informar-formacao-superior.model';

@Component
export default class TaskUserInformarFormacaoSuperiorDetailsComponent extends Vue {
  private taskUserInformarFormacaoSuperiorService: TaskUserInformarFormacaoSuperiorService = new TaskUserInformarFormacaoSuperiorService();
  private taskContext: TaskUserInformarFormacaoSuperiorContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskUserInformarFormacaoSuperiorService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
