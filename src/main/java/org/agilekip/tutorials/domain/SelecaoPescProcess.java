package org.agilekip.tutorials.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A SelecaoPescProcess.
 */
@Entity
@Table(name = "selecao_pesc_process")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SelecaoPescProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties(value = { "processDefinition" }, allowSetters = true)
    private ProcessInstance processInstance;

    @ManyToOne
    private SelecaoPesc selecaoPesc;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SelecaoPescProcess id(Long id) {
        this.id = id;
        return this;
    }

    public ProcessInstance getProcessInstance() {
        return this.processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public SelecaoPescProcess processInstance(ProcessInstance processInstance) {
        this.setProcessInstance(processInstance);
        return this;
    }

    public SelecaoPesc getSelecaoPesc() {
        return this.selecaoPesc;
    }

    public void setSelecaoPesc(SelecaoPesc selecaoPesc) {
        this.selecaoPesc = selecaoPesc;
    }

    public SelecaoPescProcess SelecaoPesc(SelecaoPesc selecaoPesc) {
        this.setSelecaoPesc(selecaoPesc);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SelecaoPescProcess)) {
            return false;
        }
        return id != null && id.equals(((SelecaoPescProcess) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SelecaoPescProcess{" +
            "id=" + getId() +
            "}";
    }
}
