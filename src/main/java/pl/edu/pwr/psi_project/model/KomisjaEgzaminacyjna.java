package pl.edu.pwr.psi_project.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class KomisjaEgzaminacyjna  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String sala;
    private String budynek;

    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    @NotNull
    private LocalTime time;

    @OneToMany(mappedBy = "komisjaEgzaminacyjna")
    private List<KomisjaPracownik> czlonki;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<KomisjaPracownik> getCzlonki() {
        return czlonki;
    }

    public void setCzlonki(List<KomisjaPracownik> czlonki) {
        this.czlonki = czlonki;
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
