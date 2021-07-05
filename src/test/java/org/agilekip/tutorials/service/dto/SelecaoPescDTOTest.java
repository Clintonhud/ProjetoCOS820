package org.agilekip.tutorials.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.agilekip.tutorials.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SelecaoPescDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SelecaoPescDTO.class);
        SelecaoPescDTO selecaoPescDTO1 = new SelecaoPescDTO();
        selecaoPescDTO1.setId(1L);
        SelecaoPescDTO selecaoPescDTO2 = new SelecaoPescDTO();
        assertThat(selecaoPescDTO1).isNotEqualTo(selecaoPescDTO2);
        selecaoPescDTO2.setId(selecaoPescDTO1.getId());
        assertThat(selecaoPescDTO1).isEqualTo(selecaoPescDTO2);
        selecaoPescDTO2.setId(2L);
        assertThat(selecaoPescDTO1).isNotEqualTo(selecaoPescDTO2);
        selecaoPescDTO1.setId(null);
        assertThat(selecaoPescDTO1).isNotEqualTo(selecaoPescDTO2);
    }
}
