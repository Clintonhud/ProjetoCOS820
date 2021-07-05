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
                v-text="$t('selecaoPescApp.taskUserInformarDadosPessoais.nomeCompleto')"
                for="task-user-informar-dados-pessoais-nomeCompleto"
                >Nome Completo</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeCompleto"
                id="task-user-informar-dados-pessoais-nomeCompleto"
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
                v-text="$t('selecaoPescApp.taskUserInformarDadosPessoais.emailPrincipal')"
                for="task-user-informar-dados-pessoais-emailPrincipal"
                >Email Principal</label
              >
              <input
                type="text"
                class="form-control"
                name="emailPrincipal"
                id="task-user-informar-dados-pessoais-emailPrincipal"
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
                v-text="$t('selecaoPescApp.taskUserInformarDadosPessoais.dataNascimento')"
                for="task-user-informar-dados-pessoais-dataNascimento"
                >Data Nascimento</label
              >
              <b-input-group class="mb-3">
                <b-input-group-prepend>
                  <b-form-datepicker
                    aria-controls="task-user-informar-dados-pessoais-dataNascimento"
                    v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.dataNascimento.$model"
                    name="dataNascimento"
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
                  id="task-user-informar-dados-pessoais-dataNascimento"
                  data-cy="dataNascimento"
                  type="text"
                  class="form-control"
                  name="dataNascimento"
                  :class="{
                    valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.dataNascimento.$invalid,
                    invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.dataNascimento.$invalid,
                  }"
                  v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.dataNascimento.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarDadosPessoais.cidadeNascimento')"
                for="task-user-informar-dados-pessoais-cidadeNascimento"
                >Cidade Nascimento</label
              >
              <input
                type="text"
                class="form-control"
                name="cidadeNascimento"
                id="task-user-informar-dados-pessoais-cidadeNascimento"
                data-cy="cidadeNascimento"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.cidadeNascimento.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.cidadeNascimento.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.cidadeNascimento.$model"
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

<script lang="ts" src="./task-user-informar-dados-pessoais-execute.component.ts"></script>
