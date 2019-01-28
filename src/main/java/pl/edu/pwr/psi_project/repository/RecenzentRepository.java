package pl.edu.pwr.psi_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.model.Recenzent;

import java.util.Optional;


public interface RecenzentRepository extends JpaRepository<Recenzent,Long> {

    Optional<Recenzent> findByPracownik(Pracownik pracownik);
}
