package org.agilekip.tutorials.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.agilekip.tutorials.repository.SelecaoPescRepository;
import org.agilekip.tutorials.service.SelecaoPescService;
import org.agilekip.tutorials.service.dto.SelecaoPescDTO;
import org.agilekip.tutorials.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.agilekip.tutorials.domain.SelecaoPesc}.
 */
@RestController
@RequestMapping("/api")
public class SelecaoPescResource {

    private final Logger log = LoggerFactory.getLogger(SelecaoPescResource.class);

    private final SelecaoPescService selecaoPescService;

    private final SelecaoPescRepository selecaoPescRepository;

    public SelecaoPescResource(SelecaoPescService selecaoPescService, SelecaoPescRepository selecaoPescRepository) {
        this.selecaoPescService = selecaoPescService;
        this.selecaoPescRepository = selecaoPescRepository;
    }

    /**
     * {@code GET  /selecao-pescs} : get all the selecaoPescs.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of selecaoPescs in body.
     */
    @GetMapping("/selecao-pescs")
    public List<SelecaoPescDTO> getAllSelecaoPescs() {
        log.debug("REST request to get all SelecaoPescs");
        return selecaoPescService.findAll();
    }

    /**
     * {@code GET  /selecao-pescs/:id} : get the "id" selecaoPesc.
     *
     * @param id the id of the selecaoPescDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the selecaoPescDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/selecao-pescs/{id}")
    public ResponseEntity<SelecaoPescDTO> getSelecaoPesc(@PathVariable Long id) {
        log.debug("REST request to get SelecaoPesc : {}", id);
        Optional<SelecaoPescDTO> selecaoPescDTO = selecaoPescService.findOne(id);
        return ResponseUtil.wrapOrNotFound(selecaoPescDTO);
    }
}
