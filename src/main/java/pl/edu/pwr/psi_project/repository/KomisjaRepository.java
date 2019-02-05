package pl.edu.pwr.psi_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.psi_project.model.KomisjaEgzaminacyjna;
import pl.edu.pwr.psi_project.model.Pracownik;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface KomisjaRepository extends JpaRepository<KomisjaEgzaminacyjna,Long> {

    Optional<List<KomisjaEgzaminacyjna>> findAllByDate(LocalDate date);


}
