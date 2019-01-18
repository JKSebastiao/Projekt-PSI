package pl.edu.pwr.psi_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recenzent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    private Pracownik pracownik;

    @OneToMany(mappedBy = "recenzent")
    @JsonIgnore
    private Set<PracaDyplomowa> pracyDyplomowych;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Set<PracaDyplomowa> getPracyDyplomowych() {
        return pracyDyplomowych;
    }

    public void setPracyDyplomowych(Set<PracaDyplomowa> pracyDyplomowych) {
        this.pracyDyplomowych = pracyDyplomowych;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recenzent)) return false;
        Recenzent recenzent = (Recenzent) o;
        return getId() == recenzent.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
