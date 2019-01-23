package pl.edu.pwr.psi_project.model.enumerations;

public enum StanowiskoPracownika {
    PRACOWNIK_NAUKOWO_DYDAKTYCZNY("Pracownik naukowo dydaktyczny"),
    PRACOWNIK_DYDAKTYCZNY("Pracownik dydaktyczny"),
    PRACOWNIK_NAUKOWO("Pracownik naukowo"),
    PELNOMOCNIK_DZIEKANA("Pełnomocnik dziekana");

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
