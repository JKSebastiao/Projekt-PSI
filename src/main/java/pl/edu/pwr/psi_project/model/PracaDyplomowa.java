package pl.edu.pwr.psi_project.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class PracaDyplomowa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String tytul;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "promotor_FK", insertable = false, updatable = false)
    private Promotor promotor;

    @ManyToOne
    @JoinColumn(name = "recenzent_FK")
    private Recenzent recenzent;

    private boolean hasRecenzent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Promotor getPromotor() {
        return promotor;
    }

    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }

    public Recenzent getRecenzent() {
        return recenzent;
    }
    public void setRecenzent(Recenzent recenzent) {
        this.recenzent = recenzent;
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
