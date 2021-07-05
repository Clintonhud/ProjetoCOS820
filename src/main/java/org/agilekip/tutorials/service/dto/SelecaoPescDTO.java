package org.agilekip.tutorials.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link org.agilekip.tutorials.domain.SelecaoPesc} entity.
 */
public class SelecaoPescDTO implements Serializable {

    private Long id;

    private String nomeCompleto;

    private String emailPrincipal;

    private String nacionalidade;

    private String documentoCpfPassaporte;

    private LocalDate dataNascimento;

    private String cidadeNascimento;

    private String temExperienciaProfissional;

    private String temDocencia;

    private String formacaoInstituicaoNome;

    private String formacaoCursoSuperior;

    private LocalDate formacaoInicio;

    private LocalDate formacaoTermino;

    private String empresaNome;

    private String empresaUrlSite;

    private String empresaFuncao;

    private String docenciaInstituicaoNome;

    private String docenciaInstituicaoPais;

    private String docenciaNomeDisciplina;

    private String proficienciaInglesTipoTeste;

    private Float proficienciaInglesNota;

    private String mestradoDoutorado;

    private String linhaAreaInteresse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getDocumentoCpfPassaporte() {
        return documentoCpfPassaporte;
    }

    public void setDocumentoCpfPassaporte(String documentoCpfPassaporte) {
        this.documentoCpfPassaporte = documentoCpfPassaporte;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getTemExperienciaProfissional() {
        return temExperienciaProfissional;
    }

    public void setTemExperienciaProfissional(String temExperienciaProfissional) {
        this.temExperienciaProfissional = temExperienciaProfissional;
    }

    public String getTemDocencia() {
        return temDocencia;
    }

    public void setTemDocencia(String temDocencia) {
        this.temDocencia = temDocencia;
    }

    public String getFormacaoInstituicaoNome() {
        return formacaoInstituicaoNome;
    }

    public void setFormacaoInstituicaoNome(String formacaoInstituicaoNome) {
        this.formacaoInstituicaoNome = formacaoInstituicaoNome;
    }

    public String getFormacaoCursoSuperior() {
        return formacaoCursoSuperior;
    }

    public void setFormacaoCursoSuperior(String formacaoCursoSuperior) {
        this.formacaoCursoSuperior = formacaoCursoSuperior;
    }

    public LocalDate getFormacaoInicio() {
        return formacaoInicio;
    }

    public void setFormacaoInicio(LocalDate formacaoInicio) {
        this.formacaoInicio = formacaoInicio;
    }

    public LocalDate getFormacaoTermino() {
        return formacaoTermino;
    }

    public void setFormacaoTermino(LocalDate formacaoTermino) {
        this.formacaoTermino = formacaoTermino;
    }

    public String getEmpresaNome() {
        return empresaNome;
    }

    public void setEmpresaNome(String empresaNome) {
        this.empresaNome = empresaNome;
    }

    public String getEmpresaUrlSite() {
        return empresaUrlSite;
    }

    public void setEmpresaUrlSite(String empresaUrlSite) {
        this.empresaUrlSite = empresaUrlSite;
    }

    public String getEmpresaFuncao() {
        return empresaFuncao;
    }

    public void setEmpresaFuncao(String empresaFuncao) {
        this.empresaFuncao = empresaFuncao;
    }

    public String getDocenciaInstituicaoNome() {
        return docenciaInstituicaoNome;
    }

    public void setDocenciaInstituicaoNome(String docenciaInstituicaoNome) {
        this.docenciaInstituicaoNome = docenciaInstituicaoNome;
    }

    public String getDocenciaInstituicaoPais() {
        return docenciaInstituicaoPais;
    }

    public void setDocenciaInstituicaoPais(String docenciaInstituicaoPais) {
        this.docenciaInstituicaoPais = docenciaInstituicaoPais;
    }

    public String getDocenciaNomeDisciplina() {
        return docenciaNomeDisciplina;
    }

    public void setDocenciaNomeDisciplina(String docenciaNomeDisciplina) {
        this.docenciaNomeDisciplina = docenciaNomeDisciplina;
    }

    public String getProficienciaInglesTipoTeste() {
        return proficienciaInglesTipoTeste;
    }

    public void setProficienciaInglesTipoTeste(String proficienciaInglesTipoTeste) {
        this.proficienciaInglesTipoTeste = proficienciaInglesTipoTeste;
    }

    public Float getProficienciaInglesNota() {
        return proficienciaInglesNota;
    }

    public void setProficienciaInglesNota(Float proficienciaInglesNota) {
        this.proficienciaInglesNota = proficienciaInglesNota;
    }

    public String getMestradoDoutorado() {
        return mestradoDoutorado;
    }

    public void setMestradoDoutorado(String mestradoDoutorado) {
        this.mestradoDoutorado = mestradoDoutorado;
    }

    public String getLinhaAreaInteresse() {
        return linhaAreaInteresse;
    }

    public void setLinhaAreaInteresse(String linhaAreaInteresse) {
        this.linhaAreaInteresse = linhaAreaInteresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SelecaoPescDTO)) {
            return false;
        }

        SelecaoPescDTO selecaoPescDTO = (SelecaoPescDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, selecaoPescDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SelecaoPescDTO{" +
            "id=" + getId() +
            ", nomeCompleto='" + getNomeCompleto() + "'" +
            ", emailPrincipal='" + getEmailPrincipal() + "'" +
            ", nacionalidade='" + getNacionalidade() + "'" +
            ", documentoCpfPassaporte='" + getDocumentoCpfPassaporte() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", cidadeNascimento='" + getCidadeNascimento() + "'" +
            ", temExperienciaProfissional='" + getTemExperienciaProfissional() + "'" +
            ", temDocencia='" + getTemDocencia() + "'" +
            ", formacaoInstituicaoNome='" + getFormacaoInstituicaoNome() + "'" +
            ", formacaoCursoSuperior='" + getFormacaoCursoSuperior() + "'" +
            ", formacaoInicio='" + getFormacaoInicio() + "'" +
            ", formacaoTermino='" + getFormacaoTermino() + "'" +
            ", empresaNome='" + getEmpresaNome() + "'" +
            ", empresaUrlSite='" + getEmpresaUrlSite() + "'" +
            ", empresaFuncao='" + getEmpresaFuncao() + "'" +
            ", docenciaInstituicaoNome='" + getDocenciaInstituicaoNome() + "'" +
            ", docenciaInstituicaoPais='" + getDocenciaInstituicaoPais() + "'" +
            ", docenciaNomeDisciplina='" + getDocenciaNomeDisciplina() + "'" +
            ", proficienciaInglesTipoTeste='" + getProficienciaInglesTipoTeste() + "'" +
            ", proficienciaInglesNota=" + getProficienciaInglesNota() +
            ", mestradoDoutorado='" + getMestradoDoutorado() + "'" +
            ", linhaAreaInteresse='" + getLinhaAreaInteresse() + "'" +
            "}";
    }
}
