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
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarDocencia.nomeCompleto')">nomeCompleto</label>
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
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarDocencia.emailPrincipal')">emailPrincipal</label>
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
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarDocencia.docenciaInstituicaoNome')"
                >docenciaInstituicaoNome</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="docenciaInstituicaoNome"
                id="selecao-pesc-docenciaInstituicaoNome"
                data-cy="docenciaInstituicaoNome"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.docenciaInstituicaoNome"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarDocencia.docenciaInstituicaoPais')"
                >docenciaInstituicaoPais</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="docenciaInstituicaoPais"
                id="selecao-pesc-docenciaInstituicaoPais"
                data-cy="docenciaInstituicaoPais"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.docenciaInstituicaoPais"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('selecaoPescApp.taskUserInformarDocencia.docenciaNomeDisciplina')"
                >docenciaNomeDisciplina</label
              >
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="docenciaNomeDisciplina"
                id="selecao-pesc-docenciaNomeDisciplina"
                data-cy="docenciaNomeDisciplina"
                v-model="taskContext.selecaoPescProcess.selecaoPesc.docenciaNomeDisciplina"
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
          :to="`/process-definition/SelecaoPescProcess/task/TaskUserInformarDocencia/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-user-informar-docencia-details.component.ts"></script>
