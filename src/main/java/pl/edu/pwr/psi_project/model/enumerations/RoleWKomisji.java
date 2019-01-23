package pl.edu.pwr.psi_project.model.enumerations;

public enum RoleWKomisji {

    PRZEWODNICZACY("Przewodniczą"),
    CZLONEK("Czołonek"),
    SEKRETARZ ("Sekretasz"),
    CZLONEK_SEKRETARZ("Członek e Sekretarz");

    private String description;

    RoleWKomisji(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
