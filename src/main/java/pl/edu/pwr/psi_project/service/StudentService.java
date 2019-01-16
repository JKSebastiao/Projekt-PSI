package pl.edu.pwr.psi_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.psi_project.model.Student;
import pl.edu.pwr.psi_project.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student getById(long id){
        return studentRepository.getOne(id);
    }

    public Student save(Student Student){
        return studentRepository.save(Student);
    }

    public void delete(Student Student){
        studentRepository.delete(Student);
    }

    public void deleteById(long id){
        Student Student = studentRepository.getOne(id);
        studentRepository.deleteById(id);
    }

    public Student update(long id, Student Student) {

        Student StudentOld = getById(id);
        BeanUtils.copyProperties(Student,StudentOld,"id");
        return save(StudentOld);
    }
}
