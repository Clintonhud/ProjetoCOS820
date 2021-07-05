package org.agilekip.tutorials.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.agilekip.tutorials.domain.SelecaoPesc;
import org.agilekip.tutorials.repository.SelecaoPescRepository;
import org.agilekip.tutorials.service.dto.SelecaoPescDTO;
import org.agilekip.tutorials.service.mapper.SelecaoPescMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link SelecaoPesc}.
 */
@Service
@Transactional
public class SelecaoPescService {

    private final Logger log = LoggerFactory.getLogger(SelecaoPescService.class);

    private final SelecaoPescRepository selecaoPescRepository;

    private final SelecaoPescMapper selecaoPescMapper;

    public SelecaoPescService(SelecaoPescRepository selecaoPescRepository, SelecaoPescMapper selecaoPescMapper) {
        this.selecaoPescRepository = selecaoPescRepository;
        this.selecaoPescMapper = selecaoPescMapper;
    }

    /**
     * Save a selecaoPesc.
     *
     * @param selecaoPescDTO the entity to save.
     * @return the persisted entity.
     */
    public SelecaoPescDTO save(SelecaoPescDTO selecaoPescDTO) {
        log.debug("Request to save SelecaoPesc : {}", selecaoPescDTO);
        SelecaoPesc selecaoPesc = selecaoPescMapper.toEntity(selecaoPescDTO);
        selecaoPesc = selecaoPescRepository.save(selecaoPesc);
        return selecaoPescMapper.toDto(selecaoPesc);
    }

    /**
     * Partially update a selecaoPesc.
     *
     * @param selecaoPescDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<SelecaoPescDTO> partialUpdate(SelecaoPescDTO selecaoPescDTO) {
        log.debug("Request to partially update SelecaoPesc : {}", selecaoPescDTO);

        return selecaoPescRepository
            .findById(selecaoPescDTO.getId())
            .map(
                existingSelecaoPesc -> {
                    selecaoPescMapper.partialUpdate(existingSelecaoPesc, selecaoPescDTO);
                    return existingSelecaoPesc;
                }
            )
            .map(selecaoPescRepository::save)
            .map(selecaoPescMapper::toDto);
    }

    /**
     * Get all the selecaoPescs.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<SelecaoPescDTO> findAll() {
        log.debug("Request to get all SelecaoPescs");
        return selecaoPescRepository.findAll().stream().map(selecaoPescMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one selecaoPesc by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SelecaoPescDTO> findOne(Long id) {
        log.debug("Request to get SelecaoPesc : {}", id);
        return selecaoPescRepository.findById(id).map(selecaoPescMapper::toDto);
    }

    /**
     * Delete the selecaoPesc by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SelecaoPesc : {}", id);
        selecaoPescRepository.deleteById(id);
    }
}
