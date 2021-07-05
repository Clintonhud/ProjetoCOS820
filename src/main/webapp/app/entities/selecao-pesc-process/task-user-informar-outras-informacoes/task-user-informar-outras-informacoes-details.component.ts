import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserInformarOutrasInformacoesService from './task-user-informar-outras-informacoes.service';
import { TaskUserInformarOutrasInformacoesContext } from './task-user-informar-outras-informacoes.model';

@Component
export default class TaskUserInformarOutrasInformacoesDetailsComponent extends Vue {
  private taskUserInformarOutrasInformacoesService: TaskUserInformarOutrasInformacoesService = new TaskUserInformarOutrasInformacoesService();
  private taskContext: TaskUserInformarOutrasInformacoesContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskUserInformarOutrasInformacoesService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
