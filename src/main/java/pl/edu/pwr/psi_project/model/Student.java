package pl.edu.pwr.psi_project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String imie;

    @NotBlank
    private String nazwisko;

    @NotBlank
    private String nrIndeksu;

    @OneToOne
    @JoinColumn(name = "id_pracy_dyplomowej")
    private PracaDyplomowa pracaDyplomowa;

    public Student() {
    }

    public Student(@NotBlank String imie, @NotBlank String nazwisko, @NotBlank String nrIndeksu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrIndeksu = nrIndeksu;
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

    public String getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(String nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public PracaDyplomowa getPracaDyplomowa() {
        return pracaDyplomowa;
    }

    public void setPracaDyplomowa(PracaDyplomowa pracaDyplomowa) {
        this.pracaDyplomowa = pracaDyplomowa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
