package org.agilekip.tutorials.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.agilekip.tutorials.domain.SelecaoPescProcess} entity.
 */
public class SelecaoPescProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private SelecaoPescDTO selecaoPesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public SelecaoPescDTO getSelecaoPesc() {
        return selecaoPesc;
    }

    public void setSelecaoPesc(SelecaoPescDTO selecaoPesc) {
        this.selecaoPesc = selecaoPesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SelecaoPescProcessDTO)) {
            return false;
        }

        SelecaoPescProcessDTO selecaoPescProcessDTO = (SelecaoPescProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, selecaoPescProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SelecaoPescProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", selecaoPesc=" + getSelecaoPesc() +
            "}";
    }
}
