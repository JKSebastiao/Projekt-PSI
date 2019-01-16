package pl.edu.pwr.psi_project.model.enumerations;

public enum Ocena {

    NIE_DOSTATECZNIE("Nie dostatęcznie",2.0),
    DOSTATECZNE("dostatęcznie",3.0),
    DOSTATECZNE_PLUS("dostatęcznie plus",3.5),
    DOBRE("Dobre",4.0),
    DOBRE_PLUS("Dobre plus",4.5),
    BARDZO_DOBRE("Bardzo dobre",5.0),
    CELUJACE("Celujące",5.5);

    private String slowne;
    private double liczbe;

    Ocena(String slowne, double liczbe) {
        this.slowne = slowne;
        this.liczbe = liczbe;
    }

    public String getSlowne() {
        return slowne;
    }

    public double getLiczbe() {
        return liczbe;
    }
}
