import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserRealizarCandidaturaService from './task-user-realizar-candidatura.service';
import { TaskUserRealizarCandidaturaContext } from './task-user-realizar-candidatura.model';

@Component
export default class TaskUserRealizarCandidaturaDetailsComponent extends Vue {
  private taskUserRealizarCandidaturaService: TaskUserRealizarCandidaturaService = new TaskUserRealizarCandidaturaService();
  private taskContext: TaskUserRealizarCandidaturaContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskUserRealizarCandidaturaService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
