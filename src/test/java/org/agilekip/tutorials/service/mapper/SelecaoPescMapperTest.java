package org.agilekip.tutorials.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SelecaoPescMapperTest {

    private SelecaoPescMapper selecaoPescMapper;

    @BeforeEach
    public void setUp() {
        selecaoPescMapper = new SelecaoPescMapperImpl();
    }
}
