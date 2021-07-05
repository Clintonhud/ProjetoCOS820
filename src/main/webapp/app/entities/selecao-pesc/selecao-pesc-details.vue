<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="selecaoPesc">
        <h2 class="jh-entity-heading" data-cy="selecaoPescDetailsHeading">
          <span v-text="$t('selecaoPescApp.selecaoPesc.detail.title')">SelecaoPesc</span> {{ selecaoPesc.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.nomeCompleto')">Nome Completo</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.nomeCompleto }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.emailPrincipal')">Email Principal</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.emailPrincipal }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.nacionalidade')">Nacionalidade</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.nacionalidade }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.documentoCpfPassaporte')">Documento Cpf Passaporte</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.documentoCpfPassaporte }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.dataNascimento')">Data Nascimento</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.dataNascimento }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.cidadeNascimento')">Cidade Nascimento</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.cidadeNascimento }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.temExperienciaProfissional')">Tem Experiencia Profissional</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.temExperienciaProfissional }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.temDocencia')">Tem Docencia</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.temDocencia }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.formacaoInstituicaoNome')">Formacao Instituicao Nome</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.formacaoInstituicaoNome }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.formacaoCursoSuperior')">Formacao Curso Superior</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.formacaoCursoSuperior }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.formacaoInicio')">Formacao Inicio</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.formacaoInicio }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.formacaoTermino')">Formacao Termino</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.formacaoTermino }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.empresaNome')">Empresa Nome</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.empresaNome }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.empresaUrlSite')">Empresa Url Site</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.empresaUrlSite }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.empresaFuncao')">Empresa Funcao</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.empresaFuncao }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.docenciaInstituicaoNome')">Docencia Instituicao Nome</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.docenciaInstituicaoNome }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.docenciaInstituicaoPais')">Docencia Instituicao Pais</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.docenciaInstituicaoPais }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.docenciaNomeDisciplina')">Docencia Nome Disciplina</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.docenciaNomeDisciplina }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.proficienciaInglesTipoTeste')">Proficiencia Ingles Tipo Teste</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.proficienciaInglesTipoTeste }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.proficienciaInglesNota')">Proficiencia Ingles Nota</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.proficienciaInglesNota }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.mestradoDoutorado')">Mestrado Doutorado</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.mestradoDoutorado }}</span>
          </dd>
          <dt>
            <span v-text="$t('selecaoPescApp.selecaoPesc.linhaAreaInteresse')">Linha Area Interesse</span>
          </dt>
          <dd>
            <span>{{ selecaoPesc.linhaAreaInteresse }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./selecao-pesc-details.component.ts"></script>
