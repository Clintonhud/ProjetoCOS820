package org.agilekip.tutorials.process.selecaoPescProcess;

import org.agilekip.tutorials.domain.SelecaoPesc;
import org.agilekip.tutorials.domain.SelecaoPescProcess;
import org.agilekip.tutorials.service.dto.SelecaoPescDTO;
import org.agilekip.tutorials.service.dto.SelecaoPescProcessDTO;
import org.agilekip.tutorials.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskUserInformarFormacaoSuperiorMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    SelecaoPescProcessDTO toSelecaoPescProcessDTO(SelecaoPescProcess selecaoPescProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeCompleto", source = "nomeCompleto")
    @Mapping(target = "emailPrincipal", source = "emailPrincipal")
    @Mapping(target = "formacaoInstituicaoNome", source = "formacaoInstituicaoNome")
    @Mapping(target = "formacaoCursoSuperior", source = "formacaoCursoSuperior")
    @Mapping(target = "formacaoInicio", source = "formacaoInicio")
    @Mapping(target = "formacaoTermino", source = "formacaoTermino")
    @Mapping(target = "temExperienciaProfissional", source = "temExperienciaProfissional")
    @Mapping(target = "temDocencia", source = "temDocencia")
    SelecaoPescDTO toSelecaoPescDTO(SelecaoPesc selecaoPesc);
}
