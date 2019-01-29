package pl.edu.pwr.psi_project.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recenzent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean powolany = false;

    @OneToOne(
            cascade = CascadeType.ALL,
            optional = false)
    private Pracownik pracownik;

    @NotEmpty
    @OneToMany(mappedBy = "recenzent")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    private List<PracaDyplomowa> listaPracyDyplomowych;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPowolany() {
        return powolany;
    }

    public void setPowolany(boolean powolany) {
        this.powolany = powolany;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public List<PracaDyplomowa> getListaPracyDyplomowych() {
        return listaPracyDyplomowych;
    }

    public void setListaPracyDyplomowych(List<PracaDyplomowa> listaPracyDyplomowych) {
        this.listaPracyDyplomowych = listaPracyDyplomowych;
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
