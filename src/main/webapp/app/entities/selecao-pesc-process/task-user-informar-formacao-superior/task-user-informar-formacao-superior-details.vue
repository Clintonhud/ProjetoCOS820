<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('selecaoPescApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.nomeCompleto')"
                >nomeCompleto</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="nomeCompleto"
                id="selecao-pesc-nomeCompleto"
                data-cy="nomeCompleto"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.nomeCompleto"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.emailPrincipal')"
                >emailPrincipal</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="emailPrincipal"
                id="selecao-pesc-emailPrincipal"
                data-cy="emailPrincipal"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.emailPrincipal"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.formacaoInstituicaoNome')"
                >formacaoInstituicaoNome</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="formacaoInstituicaoNome"
                id="selecao-pesc-formacaoInstituicaoNome"
                data-cy="formacaoInstituicaoNome"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.formacaoInstituicaoNome"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.formacaoCursoSuperior')"
                >formacaoCursoSuperior</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="formacaoCursoSuperior"
                id="selecao-pesc-formacaoCursoSuperior"
                data-cy="formacaoCursoSuperior"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.formacaoCursoSuperior"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.formacaoInicio')"
                >formacaoInicio</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="formacaoInicio"
                id="selecao-pesc-formacaoInicio"
                data-cy="formacaoInicio"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.formacaoInicio"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.formacaoTermino')"
                >formacaoTermino</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="formacaoTermino"
                id="selecao-pesc-formacaoTermino"
                data-cy="formacaoTermino"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.formacaoTermino"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.temExperienciaProfissional')"
                >temExperienciaProfissional</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="temExperienciaProfissional"
                id="selecao-pesc-temExperienciaProfissional"
                data-cy="temExperienciaProfissional"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.temExperienciaProfissional"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.temDocencia')"
                >temDocencia</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="temDocencia"
                id="selecao-pesc-temDocencia"
                data-cy="temDocencia"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.temDocencia"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/SelecaoPescProcess/task/TaskUserInformarFormacaoSuperior/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-user-informar-formacao-superior-details.component.ts"></script>
