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
                v-text="$t('selecaoPescApp.taskUserInformarOutrasInformacoes.nomeCompleto')"
                for="task-user-informar-outras-informacoes-nomeCompleto"
                >Nome Completo</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeCompleto"
                id="task-user-informar-outras-informacoes-nomeCompleto"
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
                v-text="$t('selecaoPescApp.taskUserInformarOutrasInformacoes.emailPrincipal')"
                for="task-user-informar-outras-informacoes-emailPrincipal"
                >Email Principal</label
              >
              <input
                type="text"
                class="form-control"
                name="emailPrincipal"
                id="task-user-informar-outras-informacoes-emailPrincipal"
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
                v-text="$t('selecaoPescApp.taskUserInformarOutrasInformacoes.proficienciaInglesTipoTeste')"
                for="task-user-informar-outras-informacoes-proficienciaInglesTipoTeste"
                >Proficiencia Ingles Tipo Teste</label
              >
              <input
                type="text"
                class="form-control"
                name="proficienciaInglesTipoTeste"
                id="task-user-informar-outras-informacoes-proficienciaInglesTipoTeste"
                data-cy="proficienciaInglesTipoTeste"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.proficienciaInglesTipoTeste.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.proficienciaInglesTipoTeste.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.proficienciaInglesTipoTeste.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserInformarOutrasInformacoes.proficienciaInglesNota')"
                for="task-user-informar-outras-informacoes-proficienciaInglesNota"
                >Proficiencia Ingles Nota</label
              >
              <input
                type="number"
                class="form-control"
                name="proficienciaInglesNota"
                id="task-user-informar-outras-informacoes-proficienciaInglesNota"
                data-cy="proficienciaInglesNota"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.proficienciaInglesNota.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.proficienciaInglesNota.$invalid,
                }"
                v-model.number="$v.taskContext.selecaoPescProcess.selecaoPesc.proficienciaInglesNota.$model"
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

<script lang="ts" src="./task-user-informar-outras-informacoes-execute.component.ts"></script>
