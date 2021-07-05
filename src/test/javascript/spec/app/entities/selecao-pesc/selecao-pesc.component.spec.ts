/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SelecaoPescComponent from '@/entities/selecao-pesc/selecao-pesc.vue';
import SelecaoPescClass from '@/entities/selecao-pesc/selecao-pesc.component';
import SelecaoPescService from '@/entities/selecao-pesc/selecao-pesc.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('SelecaoPesc Management Component', () => {
    let wrapper: Wrapper<SelecaoPescClass>;
    let comp: SelecaoPescClass;
    let selecaoPescServiceStub: SinonStubbedInstance<SelecaoPescService>;

    beforeEach(() => {
      selecaoPescServiceStub = sinon.createStubInstance<SelecaoPescService>(SelecaoPescService);
      selecaoPescServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<SelecaoPescClass>(SelecaoPescComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          selecaoPescService: () => selecaoPescServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      selecaoPescServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllSelecaoPescs();
      await comp.$nextTick();

      // THEN
      expect(selecaoPescServiceStub.retrieve.called).toBeTruthy();
      expect(comp.selecaoPescs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
