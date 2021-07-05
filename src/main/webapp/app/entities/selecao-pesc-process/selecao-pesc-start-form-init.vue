<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="selecaoPescApp.selecaoPescStartForm.home.createOrEditLabel"
          data-cy="SelecaoPescStartFormCreateUpdateHeading"
          v-text="$t('selecaoPescApp.selecaoPescStartForm.home.createOrEditLabel')"
        >
          Create or edit a SelecaoPescStartForm
        </h2>
        <div v-if="selecaoPescProcess.processInstance">
          <akip-show-process-definition :processDefinition="selecaoPescProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="selecaoPescProcess.selecaoPesc">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('selecaoPescApp.selecaoPescStartForm.nomeCompleto')"
                    for="selecao-pesc-start-form-nomeCompleto"
                    >Nome Completo</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="nomeCompleto"
                    id="selecao-pesc-start-form-nomeCompleto"
                    data-cy="nomeCompleto"
                    :class="{
                      valid: !$v.selecaoPescProcess.selecaoPesc.nomeCompleto.$invalid,
                      invalid: $v.selecaoPescProcess.selecaoPesc.nomeCompleto.$invalid,
                    }"
                    v-model="$v.selecaoPescProcess.selecaoPesc.nomeCompleto.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('selecaoPescApp.selecaoPescStartForm.emailPrincipal')"
                    for="selecao-pesc-start-form-emailPrincipal"
                    >Email Principal</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="emailPrincipal"
                    id="selecao-pesc-start-form-emailPrincipal"
                    data-cy="emailPrincipal"
                    :class="{
                      valid: !$v.selecaoPescProcess.selecaoPesc.emailPrincipal.$invalid,
                      invalid: $v.selecaoPescProcess.selecaoPesc.emailPrincipal.$invalid,
                    }"
                    v-model="$v.selecaoPescProcess.selecaoPesc.emailPrincipal.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('selecaoPescApp.selecaoPescStartForm.nacionalidade')"
                    for="selecao-pesc-start-form-nacionalidade"
                    >Nacionalidade</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="nacionalidade"
                    id="selecao-pesc-start-form-nacionalidade"
                    data-cy="nacionalidade"
                    :class="{
                      valid: !$v.selecaoPescProcess.selecaoPesc.nacionalidade.$invalid,
                      invalid: $v.selecaoPescProcess.selecaoPesc.nacionalidade.$invalid,
                    }"
                    v-model="$v.selecaoPescProcess.selecaoPesc.nacionalidade.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('selecaoPescApp.selecaoPescStartForm.documentoCpfPassaporte')"
                    for="selecao-pesc-start-form-documentoCpfPassaporte"
                    >Documento Cpf Passaporte</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="documentoCpfPassaporte"
                    id="selecao-pesc-start-form-documentoCpfPassaporte"
                    data-cy="documentoCpfPassaporte"
                    :class="{
                      valid: !$v.selecaoPescProcess.selecaoPesc.documentoCpfPassaporte.$invalid,
                      invalid: $v.selecaoPescProcess.selecaoPesc.documentoCpfPassaporte.$invalid,
                    }"
                    v-model="$v.selecaoPescProcess.selecaoPesc.documentoCpfPassaporte.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.selecaoPescProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./selecao-pesc-start-form-init.component.ts"></script>
