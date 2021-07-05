<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('selecaoPescApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarDocencia.nomeCompleto')"
                for="task-user-informar-docencia-nomeCompleto"
                >Nome Completo</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeCompleto"
                id="task-user-informar-docencia-nomeCompleto"
                data-cy="nomeCompleto"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.nomeCompleto.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.nomeCompleto.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.nomeCompleto.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarDocencia.emailPrincipal')"
                for="task-user-informar-docencia-emailPrincipal"
                >Email Principal</label
              >
              <input
                type="text"
                class="form-control"
                name="emailPrincipal"
                id="task-user-informar-docencia-emailPrincipal"
                data-cy="emailPrincipal"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.emailPrincipal.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.emailPrincipal.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.emailPrincipal.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarDocencia.docenciaInstituicaoNome')"
                for="task-user-informar-docencia-docenciaInstituicaoNome"
                >Docencia Instituicao Nome</label
              >
              <input
                type="text"
                class="form-control"
                name="docenciaInstituicaoNome"
                id="task-user-informar-docencia-docenciaInstituicaoNome"
                data-cy="docenciaInstituicaoNome"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.docenciaInstituicaoNome.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.docenciaInstituicaoNome.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.docenciaInstituicaoNome.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarDocencia.docenciaInstituicaoPais')"
                for="task-user-informar-docencia-docenciaInstituicaoPais"
                >Docencia Instituicao Pais</label
              >
              <input
                type="text"
                class="form-control"
                name="docenciaInstituicaoPais"
                id="task-user-informar-docencia-docenciaInstituicaoPais"
                data-cy="docenciaInstituicaoPais"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.docenciaInstituicaoPais.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.docenciaInstituicaoPais.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.docenciaInstituicaoPais.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarDocencia.docenciaNomeDisciplina')"
                for="task-user-informar-docencia-docenciaNomeDisciplina"
                >Docencia Nome Disciplina</label
              >
              <input
                type="text"
                class="form-control"
                name="docenciaNomeDisciplina"
                id="task-user-informar-docencia-docenciaNomeDisciplina"
                data-cy="docenciaNomeDisciplina"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.docenciaNomeDisciplina.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.docenciaNomeDisciplina.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.docenciaNomeDisciplina.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-user-informar-docencia-execute.component.ts"></script>
