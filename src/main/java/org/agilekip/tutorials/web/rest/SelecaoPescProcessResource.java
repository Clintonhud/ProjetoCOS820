package org.agilekip.tutorials.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.agilekip.tutorials.service.SelecaoPescProcessService;
import org.agilekip.tutorials.service.dto.SelecaoPescProcessDTO;
import org.agilekip.tutorials.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.agilekip.tutorials.domain.SelecaoPescProcess}.
 */
@RestController
@RequestMapping("/api")
public class SelecaoPescProcessResource {

    private final Logger log = LoggerFactory.getLogger(SelecaoPescProcessResource.class);

    private static final String ENTITY_NAME = "selecaoPescProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SelecaoPescProcessService selecaoPescProcessService;

    public SelecaoPescProcessResource(SelecaoPescProcessService selecaoPescProcessService) {
        this.selecaoPescProcessService = selecaoPescProcessService;
    }

    /**
     * {@code POST  /selecao-pesc-processes} : Create a new selecaoPescProcess.
     *
     * @param selecaoPescProcessDTO the selecaoPescProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new selecaoPescProcessDTO, or with status {@code 400 (Bad Request)} if the selecaoPescProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/selecao-pesc-processes")
    public ResponseEntity<SelecaoPescProcessDTO> create(@RequestBody SelecaoPescProcessDTO selecaoPescProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save SelecaoPescProcess : {}", selecaoPescProcessDTO);
        if (selecaoPescProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new selecaoPescProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SelecaoPescProcessDTO result = selecaoPescProcessService.create(selecaoPescProcessDTO);
        return ResponseEntity
            .created(new URI("/api/selecao-pesc-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /selecao-pesc-processes} : get all the selecaoPescProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of selecaoPescProcesss in body.
     */
    @GetMapping("/selecao-pesc-processes")
    public List<SelecaoPescProcessDTO> getAllSelecaoPescProcesss() {
        log.debug("REST request to get all SelecaoPescProcesss");
        return selecaoPescProcessService.findAll();
    }

    /**
     * {@code GET  /selecao-pesc-processes/:id} : get the "id" selecaoPescProcess.
     *
     * @param processInstanceId the id of the selecaoPescProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the selecaoPescProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/selecao-pesc-processes/{processInstanceId}")
    public ResponseEntity<SelecaoPescProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get SelecaoPescProcess by processInstanceId : {}", processInstanceId);
        Optional<SelecaoPescProcessDTO> selecaoPescProcessDTO = selecaoPescProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(selecaoPescProcessDTO);
    }
}
