package org.agilekip.tutorials.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.agilekip.tutorials.IntegrationTest;
import org.agilekip.tutorials.domain.SelecaoPesc;
import org.agilekip.tutorials.repository.SelecaoPescRepository;
import org.agilekip.tutorials.service.dto.SelecaoPescDTO;
import org.agilekip.tutorials.service.mapper.SelecaoPescMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link SelecaoPescResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SelecaoPescResourceIT {

    private static final String DEFAULT_NOME_COMPLETO = "AAAAAAAAAA";
    private static final String UPDATED_NOME_COMPLETO = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_PRINCIPAL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_PRINCIPAL = "BBBBBBBBBB";

    private static final String DEFAULT_NACIONALIDADE = "AAAAAAAAAA";
    private static final String UPDATED_NACIONALIDADE = "BBBBBBBBBB";

    private static final String DEFAULT_DOCUMENTO_CPF_PASSAPORTE = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENTO_CPF_PASSAPORTE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATA_NASCIMENTO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA_NASCIMENTO = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CIDADE_NASCIMENTO = "AAAAAAAAAA";
    private static final String UPDATED_CIDADE_NASCIMENTO = "BBBBBBBBBB";

    private static final String DEFAULT_TEM_EXPERIENCIA_PROFISSIONAL = "AAAAAAAAAA";
    private static final String UPDATED_TEM_EXPERIENCIA_PROFISSIONAL = "BBBBBBBBBB";

    private static final String DEFAULT_TEM_DOCENCIA = "AAAAAAAAAA";
    private static final String UPDATED_TEM_DOCENCIA = "BBBBBBBBBB";

    private static final String DEFAULT_FORMACAO_INSTITUICAO_NOME = "AAAAAAAAAA";
    private static final String UPDATED_FORMACAO_INSTITUICAO_NOME = "BBBBBBBBBB";

    private static final String DEFAULT_FORMACAO_CURSO_SUPERIOR = "AAAAAAAAAA";
    private static final String UPDATED_FORMACAO_CURSO_SUPERIOR = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_FORMACAO_INICIO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FORMACAO_INICIO = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_FORMACAO_TERMINO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FORMACAO_TERMINO = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_EMPRESA_NOME = "AAAAAAAAAA";
    private static final String UPDATED_EMPRESA_NOME = "BBBBBBBBBB";

    private static final String DEFAULT_EMPRESA_URL_SITE = "AAAAAAAAAA";
    private static final String UPDATED_EMPRESA_URL_SITE = "BBBBBBBBBB";

    private static final String DEFAULT_EMPRESA_FUNCAO = "AAAAAAAAAA";
    private static final String UPDATED_EMPRESA_FUNCAO = "BBBBBBBBBB";

    private static final String DEFAULT_DOCENCIA_INSTITUICAO_NOME = "AAAAAAAAAA";
    private static final String UPDATED_DOCENCIA_INSTITUICAO_NOME = "BBBBBBBBBB";

    private static final String DEFAULT_DOCENCIA_INSTITUICAO_PAIS = "AAAAAAAAAA";
    private static final String UPDATED_DOCENCIA_INSTITUICAO_PAIS = "BBBBBBBBBB";

    private static final String DEFAULT_DOCENCIA_NOME_DISCIPLINA = "AAAAAAAAAA";
    private static final String UPDATED_DOCENCIA_NOME_DISCIPLINA = "BBBBBBBBBB";

    private static final String DEFAULT_PROFICIENCIA_INGLES_TIPO_TESTE = "AAAAAAAAAA";
    private static final String UPDATED_PROFICIENCIA_INGLES_TIPO_TESTE = "BBBBBBBBBB";

    private static final Float DEFAULT_PROFICIENCIA_INGLES_NOTA = 1F;
    private static final Float UPDATED_PROFICIENCIA_INGLES_NOTA = 2F;

    private static final String DEFAULT_MESTRADO_DOUTORADO = "AAAAAAAAAA";
    private static final String UPDATED_MESTRADO_DOUTORADO = "BBBBBBBBBB";

    private static final String DEFAULT_LINHA_AREA_INTERESSE = "AAAAAAAAAA";
    private static final String UPDATED_LINHA_AREA_INTERESSE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/selecao-pescs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SelecaoPescRepository selecaoPescRepository;

    @Autowired
    private SelecaoPescMapper selecaoPescMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSelecaoPescMockMvc;

    private SelecaoPesc selecaoPesc;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SelecaoPesc createEntity(EntityManager em) {
        SelecaoPesc selecaoPesc = new SelecaoPesc()
            .nomeCompleto(DEFAULT_NOME_COMPLETO)
            .emailPrincipal(DEFAULT_EMAIL_PRINCIPAL)
            .nacionalidade(DEFAULT_NACIONALIDADE)
            .documentoCpfPassaporte(DEFAULT_DOCUMENTO_CPF_PASSAPORTE)
            .dataNascimento(DEFAULT_DATA_NASCIMENTO)
            .cidadeNascimento(DEFAULT_CIDADE_NASCIMENTO)
            .temExperienciaProfissional(DEFAULT_TEM_EXPERIENCIA_PROFISSIONAL)
            .temDocencia(DEFAULT_TEM_DOCENCIA)
            .formacaoInstituicaoNome(DEFAULT_FORMACAO_INSTITUICAO_NOME)
            .formacaoCursoSuperior(DEFAULT_FORMACAO_CURSO_SUPERIOR)
            .formacaoInicio(DEFAULT_FORMACAO_INICIO)
            .formacaoTermino(DEFAULT_FORMACAO_TERMINO)
            .empresaNome(DEFAULT_EMPRESA_NOME)
            .empresaUrlSite(DEFAULT_EMPRESA_URL_SITE)
            .empresaFuncao(DEFAULT_EMPRESA_FUNCAO)
            .docenciaInstituicaoNome(DEFAULT_DOCENCIA_INSTITUICAO_NOME)
            .docenciaInstituicaoPais(DEFAULT_DOCENCIA_INSTITUICAO_PAIS)
            .docenciaNomeDisciplina(DEFAULT_DOCENCIA_NOME_DISCIPLINA)
            .proficienciaInglesTipoTeste(DEFAULT_PROFICIENCIA_INGLES_TIPO_TESTE)
            .proficienciaInglesNota(DEFAULT_PROFICIENCIA_INGLES_NOTA)
            .mestradoDoutorado(DEFAULT_MESTRADO_DOUTORADO)
            .linhaAreaInteresse(DEFAULT_LINHA_AREA_INTERESSE);
        return selecaoPesc;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SelecaoPesc createUpdatedEntity(EntityManager em) {
        SelecaoPesc selecaoPesc = new SelecaoPesc()
            .nomeCompleto(UPDATED_NOME_COMPLETO)
            .emailPrincipal(UPDATED_EMAIL_PRINCIPAL)
            .nacionalidade(UPDATED_NACIONALIDADE)
            .documentoCpfPassaporte(UPDATED_DOCUMENTO_CPF_PASSAPORTE)
            .dataNascimento(UPDATED_DATA_NASCIMENTO)
            .cidadeNascimento(UPDATED_CIDADE_NASCIMENTO)
            .temExperienciaProfissional(UPDATED_TEM_EXPERIENCIA_PROFISSIONAL)
            .temDocencia(UPDATED_TEM_DOCENCIA)
            .formacaoInstituicaoNome(UPDATED_FORMACAO_INSTITUICAO_NOME)
            .formacaoCursoSuperior(UPDATED_FORMACAO_CURSO_SUPERIOR)
            .formacaoInicio(UPDATED_FORMACAO_INICIO)
            .formacaoTermino(UPDATED_FORMACAO_TERMINO)
            .empresaNome(UPDATED_EMPRESA_NOME)
            .empresaUrlSite(UPDATED_EMPRESA_URL_SITE)
            .empresaFuncao(UPDATED_EMPRESA_FUNCAO)
            .docenciaInstituicaoNome(UPDATED_DOCENCIA_INSTITUICAO_NOME)
            .docenciaInstituicaoPais(UPDATED_DOCENCIA_INSTITUICAO_PAIS)
            .docenciaNomeDisciplina(UPDATED_DOCENCIA_NOME_DISCIPLINA)
            .proficienciaInglesTipoTeste(UPDATED_PROFICIENCIA_INGLES_TIPO_TESTE)
            .proficienciaInglesNota(UPDATED_PROFICIENCIA_INGLES_NOTA)
            .mestradoDoutorado(UPDATED_MESTRADO_DOUTORADO)
            .linhaAreaInteresse(UPDATED_LINHA_AREA_INTERESSE);
        return selecaoPesc;
    }

    @BeforeEach
    public void initTest() {
        selecaoPesc = createEntity(em);
    }

    @Test
    @Transactional
    void getAllSelecaoPescs() throws Exception {
        // Initialize the database
        selecaoPescRepository.saveAndFlush(selecaoPesc);

        // Get all the selecaoPescList
        restSelecaoPescMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(selecaoPesc.getId().intValue())))
            .andExpect(jsonPath("$.[*].nomeCompleto").value(hasItem(DEFAULT_NOME_COMPLETO)))
            .andExpect(jsonPath("$.[*].emailPrincipal").value(hasItem(DEFAULT_EMAIL_PRINCIPAL)))
            .andExpect(jsonPath("$.[*].nacionalidade").value(hasItem(DEFAULT_NACIONALIDADE)))
            .andExpect(jsonPath("$.[*].documentoCpfPassaporte").value(hasItem(DEFAULT_DOCUMENTO_CPF_PASSAPORTE)))
            .andExpect(jsonPath("$.[*].dataNascimento").value(hasItem(DEFAULT_DATA_NASCIMENTO.toString())))
            .andExpect(jsonPath("$.[*].cidadeNascimento").value(hasItem(DEFAULT_CIDADE_NASCIMENTO)))
            .andExpect(jsonPath("$.[*].temExperienciaProfissional").value(hasItem(DEFAULT_TEM_EXPERIENCIA_PROFISSIONAL)))
            .andExpect(jsonPath("$.[*].temDocencia").value(hasItem(DEFAULT_TEM_DOCENCIA)))
            .andExpect(jsonPath("$.[*].formacaoInstituicaoNome").value(hasItem(DEFAULT_FORMACAO_INSTITUICAO_NOME)))
            .andExpect(jsonPath("$.[*].formacaoCursoSuperior").value(hasItem(DEFAULT_FORMACAO_CURSO_SUPERIOR)))
            .andExpect(jsonPath("$.[*].formacaoInicio").value(hasItem(DEFAULT_FORMACAO_INICIO.toString())))
            .andExpect(jsonPath("$.[*].formacaoTermino").value(hasItem(DEFAULT_FORMACAO_TERMINO.toString())))
            .andExpect(jsonPath("$.[*].empresaNome").value(hasItem(DEFAULT_EMPRESA_NOME)))
            .andExpect(jsonPath("$.[*].empresaUrlSite").value(hasItem(DEFAULT_EMPRESA_URL_SITE)))
            .andExpect(jsonPath("$.[*].empresaFuncao").value(hasItem(DEFAULT_EMPRESA_FUNCAO)))
            .andExpect(jsonPath("$.[*].docenciaInstituicaoNome").value(hasItem(DEFAULT_DOCENCIA_INSTITUICAO_NOME)))
            .andExpect(jsonPath("$.[*].docenciaInstituicaoPais").value(hasItem(DEFAULT_DOCENCIA_INSTITUICAO_PAIS)))
            .andExpect(jsonPath("$.[*].docenciaNomeDisciplina").value(hasItem(DEFAULT_DOCENCIA_NOME_DISCIPLINA)))
            .andExpect(jsonPath("$.[*].proficienciaInglesTipoTeste").value(hasItem(DEFAULT_PROFICIENCIA_INGLES_TIPO_TESTE)))
            .andExpect(jsonPath("$.[*].proficienciaInglesNota").value(hasItem(DEFAULT_PROFICIENCIA_INGLES_NOTA.doubleValue())))
            .andExpect(jsonPath("$.[*].mestradoDoutorado").value(hasItem(DEFAULT_MESTRADO_DOUTORADO)))
            .andExpect(jsonPath("$.[*].linhaAreaInteresse").value(hasItem(DEFAULT_LINHA_AREA_INTERESSE)));
    }

    @Test
    @Transactional
    void getSelecaoPesc() throws Exception {
        // Initialize the database
        selecaoPescRepository.saveAndFlush(selecaoPesc);

        // Get the selecaoPesc
        restSelecaoPescMockMvc
            .perform(get(ENTITY_API_URL_ID, selecaoPesc.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(selecaoPesc.getId().intValue()))
            .andExpect(jsonPath("$.nomeCompleto").value(DEFAULT_NOME_COMPLETO))
            .andExpect(jsonPath("$.emailPrincipal").value(DEFAULT_EMAIL_PRINCIPAL))
            .andExpect(jsonPath("$.nacionalidade").value(DEFAULT_NACIONALIDADE))
            .andExpect(jsonPath("$.documentoCpfPassaporte").value(DEFAULT_DOCUMENTO_CPF_PASSAPORTE))
            .andExpect(jsonPath("$.dataNascimento").value(DEFAULT_DATA_NASCIMENTO.toString()))
            .andExpect(jsonPath("$.cidadeNascimento").value(DEFAULT_CIDADE_NASCIMENTO))
            .andExpect(jsonPath("$.temExperienciaProfissional").value(DEFAULT_TEM_EXPERIENCIA_PROFISSIONAL))
            .andExpect(jsonPath("$.temDocencia").value(DEFAULT_TEM_DOCENCIA))
            .andExpect(jsonPath("$.formacaoInstituicaoNome").value(DEFAULT_FORMACAO_INSTITUICAO_NOME))
            .andExpect(jsonPath("$.formacaoCursoSuperior").value(DEFAULT_FORMACAO_CURSO_SUPERIOR))
            .andExpect(jsonPath("$.formacaoInicio").value(DEFAULT_FORMACAO_INICIO.toString()))
            .andExpect(jsonPath("$.formacaoTermino").value(DEFAULT_FORMACAO_TERMINO.toString()))
            .andExpect(jsonPath("$.empresaNome").value(DEFAULT_EMPRESA_NOME))
            .andExpect(jsonPath("$.empresaUrlSite").value(DEFAULT_EMPRESA_URL_SITE))
            .andExpect(jsonPath("$.empresaFuncao").value(DEFAULT_EMPRESA_FUNCAO))
            .andExpect(jsonPath("$.docenciaInstituicaoNome").value(DEFAULT_DOCENCIA_INSTITUICAO_NOME))
            .andExpect(jsonPath("$.docenciaInstituicaoPais").value(DEFAULT_DOCENCIA_INSTITUICAO_PAIS))
            .andExpect(jsonPath("$.docenciaNomeDisciplina").value(DEFAULT_DOCENCIA_NOME_DISCIPLINA))
            .andExpect(jsonPath("$.proficienciaInglesTipoTeste").value(DEFAULT_PROFICIENCIA_INGLES_TIPO_TESTE))
            .andExpect(jsonPath("$.proficienciaInglesNota").value(DEFAULT_PROFICIENCIA_INGLES_NOTA.doubleValue()))
            .andExpect(jsonPath("$.mestradoDoutorado").value(DEFAULT_MESTRADO_DOUTORADO))
            .andExpect(jsonPath("$.linhaAreaInteresse").value(DEFAULT_LINHA_AREA_INTERESSE));
    }

    @Test
    @Transactional
    void getNonExistingSelecaoPesc() throws Exception {
        // Get the selecaoPesc
        restSelecaoPescMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
