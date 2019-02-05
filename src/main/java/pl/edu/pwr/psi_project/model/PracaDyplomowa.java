package pl.edu.pwr.psi_project.model;

import pl.edu.pwr.psi_project.model.enumerations.Stopien;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class PracaDyplomowa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String tytulPoPolsku;

    @NotNull
    private String tytulPoAngielsku;

    @NotNull
    private String kierunek;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Stopien stopien;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "promotor_FK", insertable = false, updatable = false)
    private Pracownik promotor;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType. LAZY)
    @JoinTable(name = "praca_dyplomowa_recenzent",
            joinColumns = {@JoinColumn(
                    name = "id_recenzenta",
                    nullable = false,
                    updatable = false)},
            inverseJoinColumns = {@JoinColumn(
                    name = "id_pracy_dyplomowej",
                    nullable = false,
                    updatable = false)})
    private List<Pracownik> recenzenci;

    private boolean hasRecenzent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTytulPoPolsku() {
        return tytulPoPolsku;
    }

    public void setTytulPoPolsku(String tytulPoPolsku) {
        this.tytulPoPolsku = tytulPoPolsku;
    }

    public String getTytulPoAngielsku() {
        return tytulPoAngielsku;
    }

    public void setTytulPoAngielsku(String tytulPoAngielsku) {
        this.tytulPoAngielsku = tytulPoAngielsku;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public Stopien getStopien() {
        return stopien;
    }

    public void setStopien(Stopien stopien) {
        this.stopien = stopien;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Pracownik getPromotor() {
        return promotor;
    }

    public void setPromotor(Pracownik promotor) {
        this.promotor = promotor;
    }

    public List<Pracownik> getRecenzenci() {
        return recenzenci;
    }

    public void setRecenzenci(List<Pracownik> recenzenci) {
        this.recenzenci = recenzenci;
    }

    public boolean isHasRecenzent() {
        return hasRecenzent = false;
    }

    public void setHasRecenzent(boolean hasRecenzent) {
        this.hasRecenzent = hasRecenzent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PracaDyplomowa)) return false;
        PracaDyplomowa that = (PracaDyplomowa) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
