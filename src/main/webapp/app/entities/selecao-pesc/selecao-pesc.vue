<template>
  <div>
    <h2 id="page-heading" data-cy="SelecaoPescHeading">
      <span v-text="$t('selecaoPescApp.selecaoPesc.home.title')" id="selecao-pesc-heading">Selecao Pescs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('selecaoPescApp.selecaoPesc.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && selecaoPescs && selecaoPescs.length === 0">
      <span v-text="$t('selecaoPescApp.selecaoPesc.home.notFound')">No selecaoPescs found</span>
    </div>
    <div class="table-responsive" v-if="selecaoPescs && selecaoPescs.length > 0">
      <table class="table table-striped" aria-describedby="selecaoPescs">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.nomeCompleto')">Nome Completo</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.emailPrincipal')">Email Principal</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.nacionalidade')">Nacionalidade</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.documentoCpfPassaporte')">Documento Cpf Passaporte</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.dataNascimento')">Data Nascimento</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.cidadeNascimento')">Cidade Nascimento</span></th>
            <th scope="row">
              <span v-text="$t('selecaoPescApp.selecaoPesc.temExperienciaProfissional')">Tem Experiencia Profissional</span>
            </th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.temDocencia')">Tem Docencia</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.formacaoInstituicaoNome')">Formacao Instituicao Nome</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.formacaoCursoSuperior')">Formacao Curso Superior</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.formacaoInicio')">Formacao Inicio</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.formacaoTermino')">Formacao Termino</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.empresaNome')">Empresa Nome</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.empresaUrlSite')">Empresa Url Site</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.empresaFuncao')">Empresa Funcao</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.docenciaInstituicaoNome')">Docencia Instituicao Nome</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.docenciaInstituicaoPais')">Docencia Instituicao Pais</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.docenciaNomeDisciplina')">Docencia Nome Disciplina</span></th>
            <th scope="row">
              <span v-text="$t('selecaoPescApp.selecaoPesc.proficienciaInglesTipoTeste')">Proficiencia Ingles Tipo Teste</span>
            </th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.proficienciaInglesNota')">Proficiencia Ingles Nota</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.mestradoDoutorado')">Mestrado Doutorado</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPesc.linhaAreaInteresse')">Linha Area Interesse</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="selecaoPesc in selecaoPescs" :key="selecaoPesc.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'SelecaoPescView', params: { selecaoPescId: selecaoPesc.id } }">{{ selecaoPesc.id }}</router-link>
            </td>
            <td>{{ selecaoPesc.nomeCompleto }}</td>
            <td>{{ selecaoPesc.emailPrincipal }}</td>
            <td>{{ selecaoPesc.nacionalidade }}</td>
            <td>{{ selecaoPesc.documentoCpfPassaporte }}</td>
            <td>{{ selecaoPesc.dataNascimento }}</td>
            <td>{{ selecaoPesc.cidadeNascimento }}</td>
            <td>{{ selecaoPesc.temExperienciaProfissional }}</td>
            <td>{{ selecaoPesc.temDocencia }}</td>
            <td>{{ selecaoPesc.formacaoInstituicaoNome }}</td>
            <td>{{ selecaoPesc.formacaoCursoSuperior }}</td>
            <td>{{ selecaoPesc.formacaoInicio }}</td>
            <td>{{ selecaoPesc.formacaoTermino }}</td>
            <td>{{ selecaoPesc.empresaNome }}</td>
            <td>{{ selecaoPesc.empresaUrlSite }}</td>
            <td>{{ selecaoPesc.empresaFuncao }}</td>
            <td>{{ selecaoPesc.docenciaInstituicaoNome }}</td>
            <td>{{ selecaoPesc.docenciaInstituicaoPais }}</td>
            <td>{{ selecaoPesc.docenciaNomeDisciplina }}</td>
            <td>{{ selecaoPesc.proficienciaInglesTipoTeste }}</td>
            <td>{{ selecaoPesc.proficienciaInglesNota }}</td>
            <td>{{ selecaoPesc.mestradoDoutorado }}</td>
            <td>{{ selecaoPesc.linhaAreaInteresse }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'SelecaoPescView', params: { selecaoPescId: selecaoPesc.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="selecaoPescApp.selecaoPesc.delete.question" data-cy="selecaoPescDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-selecaoPesc-heading" v-text="$t('selecaoPescApp.selecaoPesc.delete.question', { id: removeId })">
          Are you sure you want to delete this Selecao Pesc?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-selecaoPesc"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeSelecaoPesc()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./selecao-pesc.component.ts"></script>
