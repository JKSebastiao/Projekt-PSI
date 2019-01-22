package pl.edu.pwr.psi_project.model.enumerations;

public enum StopienNaukowy {
    LICENCJANT("lic."),
    INZINIER("inż."),
    MAGISTER("mgr."),
    MAGISTER_INZINIER("mgr.inż."),
    DOKTOR("dr."),
    DOKTOR_INZINIER("dr.inż."),
    DOKTOR_HABILITOWANY("dr.hab."),
    DOKTOR_HABILITOWANY_INZINIER("dr.hab.inż."),
    PROFESOR_DOKTOR_HABILITOWANY("prof.dr.hab."),
    PROFESOR_DOKTOR_HABILITOWANY_INZINIER("prof.dr.hab.inż.");

    private String skrot;

    StopienNaukowy(String skrot) {
        this.skrot = skrot;
    }

    public String getSkrot() {
        return skrot;
    }

    public void setSkrot(String skrot) {
        this.skrot = skrot;
    }
}
