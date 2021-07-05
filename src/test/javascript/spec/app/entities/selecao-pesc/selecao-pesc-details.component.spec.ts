/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import SelecaoPescDetailComponent from '@/entities/selecao-pesc/selecao-pesc-details.vue';
import SelecaoPescClass from '@/entities/selecao-pesc/selecao-pesc-details.component';
import SelecaoPescService from '@/entities/selecao-pesc/selecao-pesc.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SelecaoPesc Management Detail Component', () => {
    let wrapper: Wrapper<SelecaoPescClass>;
    let comp: SelecaoPescClass;
    let selecaoPescServiceStub: SinonStubbedInstance<SelecaoPescService>;

    beforeEach(() => {
      selecaoPescServiceStub = sinon.createStubInstance<SelecaoPescService>(SelecaoPescService);

      wrapper = shallowMount<SelecaoPescClass>(SelecaoPescDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { selecaoPescService: () => selecaoPescServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSelecaoPesc = { id: 123 };
        selecaoPescServiceStub.find.resolves(foundSelecaoPesc);

        // WHEN
        comp.retrieveSelecaoPesc(123);
        await comp.$nextTick();

        // THEN
        expect(comp.selecaoPesc).toBe(foundSelecaoPesc);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundSelecaoPesc = { id: 123 };
        selecaoPescServiceStub.find.resolves(foundSelecaoPesc);

        // WHEN
        comp.beforeRouteEnter({ params: { selecaoPescId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.selecaoPesc).toBe(foundSelecaoPesc);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
