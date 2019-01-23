package pl.edu.pwr.psi_project.model;

import pl.edu.pwr.psi_project.model.enumerations.RoleWKomisji;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class CzlonekKomisji  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Pracownik pracownik;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleWKomisji role;


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

    public RoleWKomisji getRole() {
        return role;
    }

    public void setRole(RoleWKomisji role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CzlonekKomisji)) return false;
        CzlonekKomisji that = (CzlonekKomisji) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
