package pl.edu.pwr.psi_project.model;

import pl.edu.pwr.psi_project.model.enumerations.StanowiskoPracownika;
import pl.edu.pwr.psi_project.model.enumerations.Tytul;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pracownik  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String imie;

    @NotBlank
    private String nazwisko;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Tytul tytul;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StanowiskoPracownika stanowiskoPracownika;

    public Pracownik() {
    }

    public Pracownik(@NotBlank String imie, @NotBlank String nazwisko, @NotNull Tytul tytul, @NotNull StanowiskoPracownika stanowiskoPracownika) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.tytul = tytul;
        this.stanowiskoPracownika = stanowiskoPracownika;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Tytul getTytul() {
        return tytul;
    }

    public void setTytul(Tytul tytul) {
        this.tytul = tytul;
    }

    public StanowiskoPracownika getStanowiskoPracownika() {
        return stanowiskoPracownika;
    }

    public void setStanowiskoPracownika(StanowiskoPracownika stanowiskoPracownika) {
        this.stanowiskoPracownika = stanowiskoPracownika;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pracownik)) return false;
        Pracownik pracownik = (Pracownik) o;
        return getId() == pracownik.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
