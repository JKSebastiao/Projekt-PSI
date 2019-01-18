package pl.edu.pwr.psi_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class KomisjaEgzaminacyjna  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "pracownik_komisja", joinColumns = @JoinColumn(name = "id_komisji"), inverseJoinColumns = @JoinColumn(name = "id_pracownik"))
    private Set<Pracownik> komisja;
    private String sala;
    private String budynek;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Pracownik> getKomisja() {

        return komisja;
    }

    public void setKomisja(Set<Pracownik> komisja) {
        this.komisja = komisja;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getBudynek() {
        return budynek;
    }

    public void setBudynek(String budynek) {
        this.budynek = budynek;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KomisjaEgzaminacyjna)) return false;
        KomisjaEgzaminacyjna that = (KomisjaEgzaminacyjna) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
