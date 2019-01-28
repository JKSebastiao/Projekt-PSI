package pl.edu.pwr.psi_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.psi_project.model.Student;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByNrIndeksu(String nrIndeksu);
}
