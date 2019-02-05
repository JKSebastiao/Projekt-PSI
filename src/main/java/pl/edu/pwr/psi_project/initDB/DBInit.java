package pl.edu.pwr.psi_project.initDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.model.Student;
import pl.edu.pwr.psi_project.model.enumerations.StanowiskoPracownika;
import pl.edu.pwr.psi_project.model.enumerations.Tytul;
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
            pracownikService.save(new Pracownik("Imie Pracownika 1", "Nazwisko Pracownika 1", Tytul.DR_HAB, StanowiskoPracownika.DOCENT));
            pracownikService.save(new Pracownik("Imie Pracownika 2", "Nazwisko Pracownika 2", Tytul.MGR_INZ, StanowiskoPracownika.DOKTORANT));
            pracownikService.save(new Pracownik("Imie Pracownika 3", "Nazwisko Pracownika 3", Tytul.DR, StanowiskoPracownika.WYKLADOWCA));
            pracownikService.save(new Pracownik("Imie Pracownika 4", "Nazwisko Pracownika 4", Tytul.INZ, StanowiskoPracownika.ASYSTENT));
            pracownikService.save(new Pracownik("Imie Pracownika 5", "Nazwisko Pracownika 5", Tytul.MGR_INZ, StanowiskoPracownika.DOCENT));
            pracownikService.save(new Pracownik("Imie Pracownika 6", "Nazwisko Pracownika 6", Tytul.MGR_INZ, StanowiskoPracownika.DOKTORANT));
            pracownikService.save(new Pracownik("Imie Pracownika 7", "Nazwisko Pracownika 7", Tytul.DR_HAB_INZ, StanowiskoPracownika.WYKLADOWCA));
            pracownikService.save(new Pracownik("Imie Pracownika 8", "Nazwisko Pracownika 8", Tytul.PROF_DR_HAB, StanowiskoPracownika.WYKLADOWCA));
            pracownikService.save(new Pracownik("Imie Pracownika 9", "Nazwisko Pracownika 9", Tytul.PROF_DR_HAB, StanowiskoPracownika.WYKLADOWCA));
        }
    }

    public void addStudent(){
        if(studentService.getAll().isEmpty()){
            studentService.save(new Student("Imię Studenta 1","Nazwisko Studenta 1","223151"));
            studentService.save(new Student("Imię Studenta 2","Nazwisko Studenta 2","223152"));
            studentService.save(new Student("Imię Studenta 3","Nazwisko Studenta 3","223153"));
            studentService.save(new Student("Imię Studenta 4","Nazwisko Studenta 4","223154"));
            studentService.save(new Student("Imię Studenta 5","Nazwisko Studenta 5","223155"));
            studentService.save(new Student("Imię Studenta 6","Nazwisko Studenta 6","223156"));
            studentService.save(new Student("Imię Studenta 7","Nazwisko Studenta 7","233157"));
            studentService.save(new Student("Imię Studenta 8","Nazwisko Studenta 8","223158"));
            studentService.save(new Student("Imię Studenta 9","Nazwisko Studenta 9","223159"));
        }
    }
}