package pl.edu.pwr.psi_project.model.enumerations;

public enum Tytul {
    LIC("lic.",1),
    INZ("inż.",2),
    MGR("mgr.",3),
    MGR_INZ("mgr.inż.",4),
    DR("dr.",5),
    DR_INZ("dr.inż.",6),
    DR_HAB("dr.hab.",7),
    DR_HAB_INZ("dr.hab.inż.",8),
    PROF_DR_HAB("prof.dr.hab.",9),
    PROF_DR_HAB_INZ("prof.dr.hab.inż.",10),
    PROF_PWR_DR_HAB("Prof. PWR dr. hab.",11);

    private String skrot;
    private int orde;

    Tytul(String skrot, int orde) {
        this.skrot = skrot;
        this.orde = orde;
    }

    public String getSkrot() {
        return skrot;
    }

    public int getOrde() {
        return orde;
    }

}
