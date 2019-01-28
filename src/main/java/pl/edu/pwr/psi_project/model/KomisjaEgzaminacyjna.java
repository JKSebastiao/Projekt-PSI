package pl.edu.pwr.psi_project.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class KomisjaEgzaminacyjna  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String sala;
    private String budynek;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "przewodniczacy_id", nullable = false)
    private Pracownik przewodniczacy;

    @ManyToOne
    @JoinColumn(name = "czlonek_id", nullable = false)
        private Pracownik czlonek;

    @ManyToOne
    @JoinColumn(name = "sekretarz_id")
    private Pracownik sekretarz;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pracownik getPrzewodniczacy() {
        return przewodniczacy;
    }

    public void setPrzewodniczacy(Pracownik przewodniczacy) {
        this.przewodniczacy = przewodniczacy;
    }

    public Pracownik getCzlonek() {
        return czlonek;
    }

    public void setCzlonek(Pracownik czlonek) {
        this.czlonek = czlonek;
    }

    public Pracownik getSekretarz() {
        return sekretarz != null ? sekretarz: czlonek;
    }

    public void setSekretarz(Pracownik sekretarz) {
        this.sekretarz = sekretarz;
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
