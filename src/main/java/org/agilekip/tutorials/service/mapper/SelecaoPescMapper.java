package org.agilekip.tutorials.service.mapper;

import org.agilekip.tutorials.domain.*;
import org.agilekip.tutorials.service.dto.SelecaoPescDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SelecaoPesc} and its DTO {@link SelecaoPescDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SelecaoPescMapper extends EntityMapper<SelecaoPescDTO, SelecaoPesc> {}
