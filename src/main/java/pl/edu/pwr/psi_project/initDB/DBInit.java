package pl.edu.pwr.psi_project.initDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.model.Student;
import pl.edu.pwr.psi_project.model.enumerations.StanowiskoPracownika;
import pl.edu.pwr.psi_project.model.enumerations.StopienNaukowy;
import pl.edu.pwr.psi_project.service.PracownikService;
import pl.edu.pwr.psi_project.service.StudentService;

@Component
public class DBInit {

    @Autowired
    private PracownikService pracownikService;

    @Autowired
    private StudentService studentService;

    public void addPracowniki(){
        if(pracownikService.getAll().isEmpty()) {
            pracownikService.save(new Pracownik("Imie Pracownika 1", "Nazwisko Pracownika 1", StopienNaukowy.DOKTOR_INZINIER, StanowiskoPracownika.PRACOWNIK_NAUKOWO_DYDAKTYCZNY));
            pracownikService.save(new Pracownik("Imie Pracownika 2", "Nazwisko Pracownika 2", StopienNaukowy.MAGISTER_INZINIER, StanowiskoPracownika.PELNOMOCNIK_DZIEKANA));
            pracownikService.save(new Pracownik("Imie Pracownika 3", "Nazwisko Pracownika 3", StopienNaukowy.DOKTOR, StanowiskoPracownika.PRACOWNIK_DYDAKTYCZNY));
        }
    }

    public void addStudent(){
        if(studentService.getAll().isEmpty()){
            studentService.save(new Student("Imię Studenta 1","Nazwisko Studenta 1","231352"));
            studentService.save(new Student("Imię Studenta 2","Nazwisko Studenta 2","222342"));
            studentService.save(new Student("Imię Studenta 3","Nazwisko Studenta 3","211322"));
        }
    }
}
