package pl.edu.pwr.psi_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.psi_project.model.KomisjaPracownik;
import pl.edu.pwr.psi_project.model.Pracownik;

import java.util.List;
import java.util.Optional;

public interface KomisjaPracownikRepository extends JpaRepository<KomisjaPracownik,Long> {
    Optional<List<KomisjaPracownik>> findAllByPracownik(Pracownik pracownik);
}
