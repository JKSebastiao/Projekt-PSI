package pl.edu.pwr.psi_project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.model.enumerations.StanowiskoPracownika;
import pl.edu.pwr.psi_project.model.enumerations.StopienNaukowy;
import pl.edu.pwr.psi_project.service.PracownikService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo (final PracownikService pracownikService){
        return (args) ->{
            pracownikService.save(new Pracownik("Imie Pracownika 1","Nazwisko Pracownika 1",StopienNaukowy.DOKTOR_INZINIER,StanowiskoPracownika.PRACOWNIK_NAUKOWO_DYDAKTYCZNY));
            pracownikService.save(new Pracownik("Imie Pracownika 2","Nazwisko Pracownika 2",StopienNaukowy.MAGISTER_INZINIER,StanowiskoPracownika.PELNOMOCNIK_DZIEKANA));
            pracownikService.save(new Pracownik("Imie Pracownika 3","Nazwisko Pracownika 3",StopienNaukowy.DOKTOR,StanowiskoPracownika.PRACOWNIK_DYDAKTYCZNY));
        };
    }
}
