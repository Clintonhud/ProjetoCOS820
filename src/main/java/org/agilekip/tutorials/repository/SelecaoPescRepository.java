package org.agilekip.tutorials.repository;

import org.agilekip.tutorials.domain.SelecaoPesc;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the SelecaoPesc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SelecaoPescRepository extends JpaRepository<SelecaoPesc, Long> {}
