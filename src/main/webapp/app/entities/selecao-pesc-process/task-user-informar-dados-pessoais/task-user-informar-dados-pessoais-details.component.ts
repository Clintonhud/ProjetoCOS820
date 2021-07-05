import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserInformarDadosPessoaisService from './task-user-informar-dados-pessoais.service';
import { TaskUserInformarDadosPessoaisContext } from './task-user-informar-dados-pessoais.model';

@Component
export default class TaskUserInformarDadosPessoaisDetailsComponent extends Vue {
  private taskUserInformarDadosPessoaisService: TaskUserInformarDadosPessoaisService = new TaskUserInformarDadosPessoaisService();
  private taskContext: TaskUserInformarDadosPessoaisContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskUserInformarDadosPessoaisService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
