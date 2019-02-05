package pl.edu.pwr.psi_project.model.enumerations;

public enum StanowiskoPracownika {
    ASYSTENT("Asystent"),
    ADMINISTRATOR("Administrator"),
    PROFESOR("Profesor"),
    DOCENT("Docent"),
    WYKLADOWCA("Wykładowce"),
    STARSZY_WYKLADOWCE("Starszy Wykładowce"),
    DOKTORANT("Doktorant");

    private String opis;

    StanowiskoPracownika(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
