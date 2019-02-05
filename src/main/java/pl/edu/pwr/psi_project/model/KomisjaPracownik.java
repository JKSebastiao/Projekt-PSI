package pl.edu.pwr.psi_project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "komisja_pracownik")
public class KomisjaPracownik  implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pracownik")
    private Pracownik pracownik;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Komiji")
    private KomisjaEgzaminacyjna komisjaEgzaminacyjna;
    @NotBlank
    private String rola;

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

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public KomisjaEgzaminacyjna getKomisjaEgzaminacyjna() {
        return komisjaEgzaminacyjna;
    }

    public void setKomisjaEgzaminacyjna(KomisjaEgzaminacyjna komisjaEgzaminacyjna) {
        this.komisjaEgzaminacyjna = komisjaEgzaminacyjna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KomisjaPracownik)) return false;
        KomisjaPracownik that = (KomisjaPracownik) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
