export interface ISelecaoPesc {
  id?: number;
  nomeCompleto?: string | null;
  emailPrincipal?: string | null;
  nacionalidade?: string | null;
  documentoCpfPassaporte?: string | null;
  dataNascimento?: Date | null;
  cidadeNascimento?: string | null;
  temExperienciaProfissional?: string | null;
  temDocencia?: string | null;
  formacaoInstituicaoNome?: string | null;
  formacaoCursoSuperior?: string | null;
  formacaoInicio?: Date | null;
  formacaoTermino?: Date | null;
  empresaNome?: string | null;
  empresaUrlSite?: string | null;
  empresaFuncao?: string | null;
  docenciaInstituicaoNome?: string | null;
  docenciaInstituicaoPais?: string | null;
  docenciaNomeDisciplina?: string | null;
  proficienciaInglesTipoTeste?: string | null;
  proficienciaInglesNota?: number | null;
  mestradoDoutorado?: string | null;
  linhaAreaInteresse?: string | null;
}

export class SelecaoPesc implements ISelecaoPesc {
  constructor(
    public id?: number,
    public nomeCompleto?: string | null,
    public emailPrincipal?: string | null,
    public nacionalidade?: string | null,
    public documentoCpfPassaporte?: string | null,
    public dataNascimento?: Date | null,
    public cidadeNascimento?: string | null,
    public temExperienciaProfissional?: string | null,
    public temDocencia?: string | null,
    public formacaoInstituicaoNome?: string | null,
    public formacaoCursoSuperior?: string | null,
    public formacaoInicio?: Date | null,
    public formacaoTermino?: Date | null,
    public empresaNome?: string | null,
    public empresaUrlSite?: string | null,
    public empresaFuncao?: string | null,
    public docenciaInstituicaoNome?: string | null,
    public docenciaInstituicaoPais?: string | null,
    public docenciaNomeDisciplina?: string | null,
    public proficienciaInglesTipoTeste?: string | null,
    public proficienciaInglesNota?: number | null,
    public mestradoDoutorado?: string | null,
    public linhaAreaInteresse?: string | null
  ) {}
}
