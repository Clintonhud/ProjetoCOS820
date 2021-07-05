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
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarOutrasInformacoes.nomeCompleto')"
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
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarOutrasInformacoes.emailPrincipal')"
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
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarOutrasInformacoes.proficienciaInglesTipoTeste')"
                >proficienciaInglesTipoTeste</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="proficienciaInglesTipoTeste"
                id="selecao-pesc-proficienciaInglesTipoTeste"
                data-cy="proficienciaInglesTipoTeste"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.proficienciaInglesTipoTeste"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarOutrasInformacoes.proficienciaInglesNota')"
                >proficienciaInglesNota</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="proficienciaInglesNota"
                id="selecao-pesc-proficienciaInglesNota"
                data-cy="proficienciaInglesNota"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.proficienciaInglesNota"
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
          :to="`/process-definition/SelecaoPescProcess/task/TaskUserInformarOutrasInformacoes/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-user-informar-outras-informacoes-details.component.ts"></script>
