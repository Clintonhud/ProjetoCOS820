package org.agilekip.tutorials.repository;

import java.util.Optional;
import org.agilekip.tutorials.domain.SelecaoPescProcess;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the SelecaoPescProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SelecaoPescProcessRepository extends JpaRepository<SelecaoPescProcess, Long> {
    Optional<SelecaoPescProcess> findByProcessInstanceId(Long processInstanceId);
}
