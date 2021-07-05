import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ISelecaoPesc } from '@/shared/model/selecao-pesc.model';

import SelecaoPescService from './selecao-pesc.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class SelecaoPesc extends Vue {
  @Inject('selecaoPescService') private selecaoPescService: () => SelecaoPescService;
  private removeId: number = null;

  public selecaoPescs: ISelecaoPesc[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllSelecaoPescs();
  }

  public clear(): void {
    this.retrieveAllSelecaoPescs();
  }

  public retrieveAllSelecaoPescs(): void {
    this.isFetching = true;

    this.selecaoPescService()
      .retrieve()
      .then(
        res => {
          this.selecaoPescs = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
