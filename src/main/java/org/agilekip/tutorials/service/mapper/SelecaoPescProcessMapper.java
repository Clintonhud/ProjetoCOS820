package org.agilekip.tutorials.service.mapper;

import org.agilekip.tutorials.domain.*;
import org.agilekip.tutorials.service.dto.SelecaoPescProcessDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SelecaoPescProcess} and its DTO {@link SelecaoPescProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, SelecaoPescMapper.class })
public interface SelecaoPescProcessMapper extends EntityMapper<SelecaoPescProcessDTO, SelecaoPescProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "selecaoPesc", source = "selecaoPesc")
    SelecaoPescProcessDTO toDto(SelecaoPescProcess s);
}
