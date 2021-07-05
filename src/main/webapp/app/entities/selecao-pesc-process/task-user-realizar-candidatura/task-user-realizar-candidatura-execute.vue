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
                v-text="$t('selecaoPescApp.taskUserRealizarCandidatura.nomeCompleto')"
                for="task-user-realizar-candidatura-nomeCompleto"
                >Nome Completo</label
              >
              <input
                type="text"
                class="form-control"
                name="nomeCompleto"
                id="task-user-realizar-candidatura-nomeCompleto"
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
                v-text="$t('selecaoPescApp.taskUserRealizarCandidatura.emailPrincipal')"
                for="task-user-realizar-candidatura-emailPrincipal"
                >Email Principal</label
              >
              <input
                type="text"
                class="form-control"
                name="emailPrincipal"
                id="task-user-realizar-candidatura-emailPrincipal"
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
                v-text="$t('selecaoPescApp.taskUserRealizarCandidatura.mestradoDoutorado')"
                for="task-user-realizar-candidatura-mestradoDoutorado"
                >Mestrado Doutorado</label
              >
              <input
                type="text"
                class="form-control"
                name="mestradoDoutorado"
                id="task-user-realizar-candidatura-mestradoDoutorado"
                data-cy="mestradoDoutorado"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.mestradoDoutorado.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.mestradoDoutorado.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.mestradoDoutorado.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('selecaoPescApp.taskUserRealizarCandidatura.linhaAreaInteresse')"
                for="task-user-realizar-candidatura-linhaAreaInteresse"
                >Linha Area Interesse</label
              >
              <input
                type="text"
                class="form-control"
                name="linhaAreaInteresse"
                id="task-user-realizar-candidatura-linhaAreaInteresse"
                data-cy="linhaAreaInteresse"
                :class="{
                  valid: !$v.taskContext.selecaoPescProcess.selecaoPesc.linhaAreaInteresse.$invalid,
                  invalid: $v.taskContext.selecaoPescProcess.selecaoPesc.linhaAreaInteresse.$invalid,
                }"
                v-model="$v.taskContext.selecaoPescProcess.selecaoPesc.linhaAreaInteresse.$model"
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

<script lang="ts" src="./task-user-realizar-candidatura-execute.component.ts"></script>
