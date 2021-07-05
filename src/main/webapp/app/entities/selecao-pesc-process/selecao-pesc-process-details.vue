<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="selecaoPescProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="selecaoPescProcessDetailsHeading">
          <span v-text="$t('selecaoPescApp.selecaoPescProcess.detail.title')">SelecaoPescProcess</span> {{ selecaoPescProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="selecaoPescProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('selecaoPescApp.selecaoPescProcess.detail.title')">SelecaoPescProcess</span> #{{ selecaoPescProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="selecaoPescProcess.selecaoPesc">
              <h5 class="card-header">
                <span class="title"> Selecao Pesc #{{ selecaoPescProcess.selecaoPesc.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.nomeCompleto')">nomeCompleto</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="nomeCompleto"
                    id="selecao-pesc-nomeCompleto"
                    data-cy="nomeCompleto"
                    v-model="selecaoPescProcess.selecaoPesc.nomeCompleto"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.emailPrincipal')">emailPrincipal</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="emailPrincipal"
                    id="selecao-pesc-emailPrincipal"
                    data-cy="emailPrincipal"
                    v-model="selecaoPescProcess.selecaoPesc.emailPrincipal"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.nacionalidade')">nacionalidade</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="nacionalidade"
                    id="selecao-pesc-nacionalidade"
                    data-cy="nacionalidade"
                    v-model="selecaoPescProcess.selecaoPesc.nacionalidade"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.documentoCpfPassaporte')"
                    >documentoCpfPassaporte</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="documentoCpfPassaporte"
                    id="selecao-pesc-documentoCpfPassaporte"
                    data-cy="documentoCpfPassaporte"
                    v-model="selecaoPescProcess.selecaoPesc.documentoCpfPassaporte"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.dataNascimento')">dataNascimento</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="dataNascimento"
                    id="selecao-pesc-dataNascimento"
                    data-cy="dataNascimento"
                    v-model="selecaoPescProcess.selecaoPesc.dataNascimento"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.cidadeNascimento')"
                    >cidadeNascimento</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="cidadeNascimento"
                    id="selecao-pesc-cidadeNascimento"
                    data-cy="cidadeNascimento"
                    v-model="selecaoPescProcess.selecaoPesc.cidadeNascimento"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.temExperienciaProfissional')"
                    >temExperienciaProfissional</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="temExperienciaProfissional"
                    id="selecao-pesc-temExperienciaProfissional"
                    data-cy="temExperienciaProfissional"
                    v-model="selecaoPescProcess.selecaoPesc.temExperienciaProfissional"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.temDocencia')">temDocencia</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="temDocencia"
                    id="selecao-pesc-temDocencia"
                    data-cy="temDocencia"
                    v-model="selecaoPescProcess.selecaoPesc.temDocencia"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.formacaoInstituicaoNome')"
                    >formacaoInstituicaoNome</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="formacaoInstituicaoNome"
                    id="selecao-pesc-formacaoInstituicaoNome"
                    data-cy="formacaoInstituicaoNome"
                    v-model="selecaoPescProcess.selecaoPesc.formacaoInstituicaoNome"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.formacaoCursoSuperior')"
                    >formacaoCursoSuperior</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="formacaoCursoSuperior"
                    id="selecao-pesc-formacaoCursoSuperior"
                    data-cy="formacaoCursoSuperior"
                    v-model="selecaoPescProcess.selecaoPesc.formacaoCursoSuperior"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.formacaoInicio')">formacaoInicio</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="formacaoInicio"
                    id="selecao-pesc-formacaoInicio"
                    data-cy="formacaoInicio"
                    v-model="selecaoPescProcess.selecaoPesc.formacaoInicio"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.formacaoTermino')">formacaoTermino</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="formacaoTermino"
                    id="selecao-pesc-formacaoTermino"
                    data-cy="formacaoTermino"
                    v-model="selecaoPescProcess.selecaoPesc.formacaoTermino"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.empresaNome')">empresaNome</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="empresaNome"
                    id="selecao-pesc-empresaNome"
                    data-cy="empresaNome"
                    v-model="selecaoPescProcess.selecaoPesc.empresaNome"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.empresaUrlSite')">empresaUrlSite</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="empresaUrlSite"
                    id="selecao-pesc-empresaUrlSite"
                    data-cy="empresaUrlSite"
                    v-model="selecaoPescProcess.selecaoPesc.empresaUrlSite"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.empresaFuncao')">empresaFuncao</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="empresaFuncao"
                    id="selecao-pesc-empresaFuncao"
                    data-cy="empresaFuncao"
                    v-model="selecaoPescProcess.selecaoPesc.empresaFuncao"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.docenciaInstituicaoNome')"
                    >docenciaInstituicaoNome</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="docenciaInstituicaoNome"
                    id="selecao-pesc-docenciaInstituicaoNome"
                    data-cy="docenciaInstituicaoNome"
                    v-model="selecaoPescProcess.selecaoPesc.docenciaInstituicaoNome"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.docenciaInstituicaoPais')"
                    >docenciaInstituicaoPais</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="docenciaInstituicaoPais"
                    id="selecao-pesc-docenciaInstituicaoPais"
                    data-cy="docenciaInstituicaoPais"
                    v-model="selecaoPescProcess.selecaoPesc.docenciaInstituicaoPais"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.docenciaNomeDisciplina')"
                    >docenciaNomeDisciplina</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="docenciaNomeDisciplina"
                    id="selecao-pesc-docenciaNomeDisciplina"
                    data-cy="docenciaNomeDisciplina"
                    v-model="selecaoPescProcess.selecaoPesc.docenciaNomeDisciplina"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.proficienciaInglesTipoTeste')"
                    >proficienciaInglesTipoTeste</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="proficienciaInglesTipoTeste"
                    id="selecao-pesc-proficienciaInglesTipoTeste"
                    data-cy="proficienciaInglesTipoTeste"
                    v-model="selecaoPescProcess.selecaoPesc.proficienciaInglesTipoTeste"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.proficienciaInglesNota')"
                    >proficienciaInglesNota</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="proficienciaInglesNota"
                    id="selecao-pesc-proficienciaInglesNota"
                    data-cy="proficienciaInglesNota"
                    v-model="selecaoPescProcess.selecaoPesc.proficienciaInglesNota"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.mestradoDoutorado')"
                    >mestradoDoutorado</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="mestradoDoutorado"
                    id="selecao-pesc-mestradoDoutorado"
                    data-cy="mestradoDoutorado"
                    v-model="selecaoPescProcess.selecaoPesc.mestradoDoutorado"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('selecaoPescApp.selecaoPescProcess.linhaAreaInteresse')"
                    >linhaAreaInteresse</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="linhaAreaInteresse"
                    id="selecao-pesc-linhaAreaInteresse"
                    data-cy="linhaAreaInteresse"
                    v-model="selecaoPescProcess.selecaoPesc.linhaAreaInteresse"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./selecao-pesc-process-details.component.ts"></script>
