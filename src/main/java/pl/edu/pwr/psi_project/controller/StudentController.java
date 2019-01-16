package pl.edu.pwr.psi_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.psi_project.model.Student;
import pl.edu.pwr.psi_project.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/studenci")
public class StudentController {

    @Autowired
    private StudentService StudentService;

    @GetMapping
    public ResponseEntity<List<Student>> Studenci(){
        List<Student> studentList = StudentService.getAll();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable long id){
        Student student = StudentService.getById(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().<Student>build();
    }

    @PostMapping
    public ResponseEntity<Student> otworzyc(@Valid @RequestBody Student student, HttpServletResponse response){
        Student studentZapisany = StudentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable long id, @Valid @RequestBody Student student){
        Student studentAktualny = StudentService.update(id,student);
        return ResponseEntity.ok(studentAktualny);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        StudentService.deleteById(id);
    }
}
