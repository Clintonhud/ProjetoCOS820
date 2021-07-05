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
                v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.nomeCompleto')"
                for="task-user-informar-formacao-superior-nomeCompleto"
                >Nome Completo</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeCompleto"
                id="task-user-informar-formacao-superior-nomeCompleto"
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
                v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.emailPrincipal')"
                for="task-user-informar-formacao-superior-emailPrincipal"
                >Email Principal</label
              >
              <input
                type="text"
                class="form-control"
                name="emailPrincipal"
                id="task-user-informar-formacao-superior-emailPrincipal"
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
                v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.formacaoInstituicaoNome')"
                for="task-user-informar-formacao-superior-formacaoInstituicaoNome"
                >Formacao Instituicao Nome</label
              >
              <input
                type="text"
                class="form-control"
                name="formacaoInstituicaoNome"
                id="task-user-informar-formacao-superior-formacaoInstituicaoNome"
                data-cy="formacaoInstituicaoNome"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.formacaoInstituicaoNome.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.formacaoInstituicaoNome.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.formacaoInstituicaoNome.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.formacaoCursoSuperior')"
                for="task-user-informar-formacao-superior-formacaoCursoSuperior"
                >Formacao Curso Superior</label
              >
              <input
                type="text"
                class="form-control"
                name="formacaoCursoSuperior"
                id="task-user-informar-formacao-superior-formacaoCursoSuperior"
                data-cy="formacaoCursoSuperior"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.formacaoCursoSuperior.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.formacaoCursoSuperior.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.formacaoCursoSuperior.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.formacaoInicio')"
                for="task-user-informar-formacao-superior-formacaoInicio"
                >Formacao Inicio</label
              >
              <b-input-group class="mb-3">
                <b-input-group-prepend>
                  <b-form-datepicker
                    aria-controls="task-user-informar-formacao-superior-formacaoInicio"
                    v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.formacaoInicio.$model"
                    name="formacaoInicio"
                    class="form-control"
                    :locale="currentLanguage"
                    button-only
                    today-button
                    reset-button
                    close-button
                  >
                  </b-form-datepicker>
                </b-input-group-prepend>
                <b-form-input
                  id="task-user-informar-formacao-superior-formacaoInicio"
                  data-cy="formacaoInicio"
                  type="text"
                  class="form-control"
                  name="formacaoInicio"
                  :class="{
                    valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.formacaoInicio.$invalid,
                    invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.formacaoInicio.$invalid,
                  }"
                  v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.formacaoInicio.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.formacaoTermino')"
                for="task-user-informar-formacao-superior-formacaoTermino"
                >Formacao Termino</label
              >
              <b-input-group class="mb-3">
                <b-input-group-prepend>
                  <b-form-datepicker
                    aria-controls="task-user-informar-formacao-superior-formacaoTermino"
                    v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.formacaoTermino.$model"
                    name="formacaoTermino"
                    class="form-control"
                    :locale="currentLanguage"
                    button-only
                    today-button
                    reset-button
                    close-button
                  >
                  </b-form-datepicker>
                </b-input-group-prepend>
                <b-form-input
                  id="task-user-informar-formacao-superior-formacaoTermino"
                  data-cy="formacaoTermino"
                  type="text"
                  class="form-control"
                  name="formacaoTermino"
                  :class="{
                    valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.formacaoTermino.$invalid,
                    invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.formacaoTermino.$invalid,
                  }"
                  v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.formacaoTermino.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.temExperienciaProfissional')"
                for="task-user-informar-formacao-superior-temExperienciaProfissional"
                >Tem Experiencia Profissional</label
              >
              <input
                type="text"
                class="form-control"
                name="temExperienciaProfissional"
                id="task-user-informar-formacao-superior-temExperienciaProfissional"
                data-cy="temExperienciaProfissional"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.temExperienciaProfissional.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.temExperienciaProfissional.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.temExperienciaProfissional.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarFormacaoSuperior.temDocencia')"
                for="task-user-informar-formacao-superior-temDocencia"
                >Tem Docencia</label
              >
              <input
                type="text"
                class="form-control"
                name="temDocencia"
                id="task-user-informar-formacao-superior-temDocencia"
                data-cy="temDocencia"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.temDocencia.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.temDocencia.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.temDocencia.$model"
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

<script lang="ts" src="./task-user-informar-formacao-superior-execute.component.ts"></script>
