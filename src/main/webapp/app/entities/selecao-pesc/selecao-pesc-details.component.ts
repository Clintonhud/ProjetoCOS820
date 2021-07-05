import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISelecaoPesc } from '@/shared/model/selecao-pesc.model';
import SelecaoPescService from './selecao-pesc.service';

@Component
export default class SelecaoPescDetails extends Vue {
  @Inject('selecaoPescService') private selecaoPescService: () => SelecaoPescService;
  public selecaoPesc: ISelecaoPesc = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.selecaoPescId) {
        vm.retrieveSelecaoPesc(to.params.selecaoPescId);
      }
    });
  }

  public retrieveSelecaoPesc(selecaoPescId) {
    this.selecaoPescService()
      .find(selecaoPescId)
      .then(res => {
        this.selecaoPesc = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
