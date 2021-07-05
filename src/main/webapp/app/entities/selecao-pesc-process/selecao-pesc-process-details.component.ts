import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISelecaoPescProcess } from '@/shared/model/selecao-pesc-process.model';
import SelecaoPescProcessService from './selecao-pesc-process.service';

@Component
export default class SelecaoPescProcessDetailsComponent extends Vue {
  @Inject('selecaoPescProcessService') private selecaoPescProcessService: () => SelecaoPescProcessService;
  public selecaoPescProcess: ISelecaoPescProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveSelecaoPescProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveSelecaoPescProcess(selecaoPescProcessId) {
    this.isFetching = true;
    this.selecaoPescProcessService()
      .find(selecaoPescProcessId)
      .then(
        res => {
          this.selecaoPescProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
