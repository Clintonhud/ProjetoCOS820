import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const SelecaoPesc = () => import('@/entities/selecao-pesc/selecao-pesc.vue');
// prettier-ignore
const SelecaoPescDetails = () => import('@/entities/selecao-pesc/selecao-pesc-details.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserInformarExperienciaProfissionalDetails = () => import('@/entities/selecao-pesc-process/task-user-informar-experiencia-profissional/task-user-informar-experiencia-profissional-details.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserInformarExperienciaProfissionalExecute = () => import('@/entities/selecao-pesc-process/task-user-informar-experiencia-profissional/task-user-informar-experiencia-profissional-execute.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserInformarDocenciaDetails = () => import('@/entities/selecao-pesc-process/task-user-informar-docencia/task-user-informar-docencia-details.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserInformarDocenciaExecute = () => import('@/entities/selecao-pesc-process/task-user-informar-docencia/task-user-informar-docencia-execute.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserInformarFormacaoSuperiorDetails = () => import('@/entities/selecao-pesc-process/task-user-informar-formacao-superior/task-user-informar-formacao-superior-details.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserInformarFormacaoSuperiorExecute = () => import('@/entities/selecao-pesc-process/task-user-informar-formacao-superior/task-user-informar-formacao-superior-execute.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserInformarOutrasInformacoesDetails = () => import('@/entities/selecao-pesc-process/task-user-informar-outras-informacoes/task-user-informar-outras-informacoes-details.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserInformarOutrasInformacoesExecute = () => import('@/entities/selecao-pesc-process/task-user-informar-outras-informacoes/task-user-informar-outras-informacoes-execute.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserInformarDadosPessoaisDetails = () => import('@/entities/selecao-pesc-process/task-user-informar-dados-pessoais/task-user-informar-dados-pessoais-details.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserInformarDadosPessoaisExecute = () => import('@/entities/selecao-pesc-process/task-user-informar-dados-pessoais/task-user-informar-dados-pessoais-execute.vue');
// prettier-ignore
const SelecaoPescStartFormInit = () => import('@/entities/selecao-pesc-process/selecao-pesc-start-form-init.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserRealizarCandidaturaDetails = () => import('@/entities/selecao-pesc-process/task-user-realizar-candidatura/task-user-realizar-candidatura-details.vue');
// prettier-ignore
const SelecaoPescProcess_TaskUserRealizarCandidaturaExecute = () => import('@/entities/selecao-pesc-process/task-user-realizar-candidatura/task-user-realizar-candidatura-execute.vue');
// prettier-ignore
const SelecaoPescProcessDetails = () => import('@/entities/selecao-pesc-process/selecao-pesc-process-details.vue');
// prettier-ignore
const SelecaoPescProcessList = () => import('@/entities/selecao-pesc-process/selecao-pesc-process-list.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/selecao-pesc',
    name: 'SelecaoPesc',
    component: SelecaoPesc,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/selecao-pesc/:selecaoPescId/view',
    name: 'SelecaoPescView',
    component: SelecaoPescDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserInformarExperienciaProfissional/:taskInstanceId/view',
    name: 'SelecaoPescProcess_TaskUserInformarExperienciaProfissionalDetails',
    component: SelecaoPescProcess_TaskUserInformarExperienciaProfissionalDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserInformarExperienciaProfissional/:taskInstanceId/execute',
    name: 'SelecaoPescProcess_TaskUserInformarExperienciaProfissionalExecute',
    component: SelecaoPescProcess_TaskUserInformarExperienciaProfissionalExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserInformarDocencia/:taskInstanceId/view',
    name: 'SelecaoPescProcess_TaskUserInformarDocenciaDetails',
    component: SelecaoPescProcess_TaskUserInformarDocenciaDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserInformarDocencia/:taskInstanceId/execute',
    name: 'SelecaoPescProcess_TaskUserInformarDocenciaExecute',
    component: SelecaoPescProcess_TaskUserInformarDocenciaExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserInformarFormacaoSuperior/:taskInstanceId/view',
    name: 'SelecaoPescProcess_TaskUserInformarFormacaoSuperiorDetails',
    component: SelecaoPescProcess_TaskUserInformarFormacaoSuperiorDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserInformarFormacaoSuperior/:taskInstanceId/execute',
    name: 'SelecaoPescProcess_TaskUserInformarFormacaoSuperiorExecute',
    component: SelecaoPescProcess_TaskUserInformarFormacaoSuperiorExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserInformarOutrasInformacoes/:taskInstanceId/view',
    name: 'SelecaoPescProcess_TaskUserInformarOutrasInformacoesDetails',
    component: SelecaoPescProcess_TaskUserInformarOutrasInformacoesDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserInformarOutrasInformacoes/:taskInstanceId/execute',
    name: 'SelecaoPescProcess_TaskUserInformarOutrasInformacoesExecute',
    component: SelecaoPescProcess_TaskUserInformarOutrasInformacoesExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserInformarDadosPessoais/:taskInstanceId/view',
    name: 'SelecaoPescProcess_TaskUserInformarDadosPessoaisDetails',
    component: SelecaoPescProcess_TaskUserInformarDadosPessoaisDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserInformarDadosPessoais/:taskInstanceId/execute',
    name: 'SelecaoPescProcess_TaskUserInformarDadosPessoaisExecute',
    component: SelecaoPescProcess_TaskUserInformarDadosPessoaisExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/init',
    name: 'SelecaoPescStartFormInit',
    component: SelecaoPescStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserRealizarCandidatura/:taskInstanceId/view',
    name: 'SelecaoPescProcess_TaskUserRealizarCandidaturaDetails',
    component: SelecaoPescProcess_TaskUserRealizarCandidaturaDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/task/TaskUserRealizarCandidatura/:taskInstanceId/execute',
    name: 'SelecaoPescProcess_TaskUserRealizarCandidaturaExecute',
    component: SelecaoPescProcess_TaskUserRealizarCandidaturaExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/instance/:processInstanceId/view',
    name: 'SelecaoPescProcessView',
    component: SelecaoPescProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SelecaoPescProcess/instances',
    name: 'SelecaoPescProcessList',
    component: SelecaoPescProcessList,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
