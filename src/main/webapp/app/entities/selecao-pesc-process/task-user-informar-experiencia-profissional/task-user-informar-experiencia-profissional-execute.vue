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
                v-text="$t('selecaoPescApp.taskUserInformarExperienciaProfissional.nomeCompleto')"
                for="task-user-informar-experiencia-profissional-nomeCompleto"
                >Nome Completo</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeCompleto"
                id="task-user-informar-experiencia-profissional-nomeCompleto"
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
                v-text="$t('selecaoPescApp.taskUserInformarExperienciaProfissional.emailPrincipal')"
                for="task-user-informar-experiencia-profissional-emailPrincipal"
                >Email Principal</label
              >
              <input
                type="text"
                class="form-control"
                name="emailPrincipal"
                id="task-user-informar-experiencia-profissional-emailPrincipal"
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
                v-text="$t('selecaoPescApp.taskUserInformarExperienciaProfissional.empresaNome')"
                for="task-user-informar-experiencia-profissional-empresaNome"
                >Empresa Nome</label
              >
              <input
                type="text"
                class="form-control"
                name="empresaNome"
                id="task-user-informar-experiencia-profissional-empresaNome"
                data-cy="empresaNome"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.empresaNome.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.empresaNome.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.empresaNome.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarExperienciaProfissional.empresaUrlSite')"
                for="task-user-informar-experiencia-profissional-empresaUrlSite"
                >Empresa Url Site</label
              >
              <input
                type="text"
                class="form-control"
                name="empresaUrlSite"
                id="task-user-informar-experiencia-profissional-empresaUrlSite"
                data-cy="empresaUrlSite"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.empresaUrlSite.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.empresaUrlSite.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.empresaUrlSite.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarExperienciaProfissional.empresaFuncao')"
                for="task-user-informar-experiencia-profissional-empresaFuncao"
                >Empresa Funcao</label
              >
              <input
                type="text"
                class="form-control"
                name="empresaFuncao"
                id="task-user-informar-experiencia-profissional-empresaFuncao"
                data-cy="empresaFuncao"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.empresaFuncao.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.empresaFuncao.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.empresaFuncao.$model"
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

<script lang="ts" src="./task-user-informar-experiencia-profissional-execute.component.ts"></script>
