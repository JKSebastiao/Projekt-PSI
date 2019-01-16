package pl.edu.pwr.psi_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.psi_project.model.KomisjaEgzaminacyjna;
import pl.edu.pwr.psi_project.model.Pracownik;


public interface KomisjaRepository extends JpaRepository<KomisjaEgzaminacyjna,Long> {
}
