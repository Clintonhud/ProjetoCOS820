package org.agilekip.tutorials.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.agilekip.tutorials.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SelecaoPescTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SelecaoPesc.class);
        SelecaoPesc selecaoPesc1 = new SelecaoPesc();
        selecaoPesc1.setId(1L);
        SelecaoPesc selecaoPesc2 = new SelecaoPesc();
        selecaoPesc2.setId(selecaoPesc1.getId());
        assertThat(selecaoPesc1).isEqualTo(selecaoPesc2);
        selecaoPesc2.setId(2L);
        assertThat(selecaoPesc1).isNotEqualTo(selecaoPesc2);
        selecaoPesc1.setId(null);
        assertThat(selecaoPesc1).isNotEqualTo(selecaoPesc2);
    }
}
