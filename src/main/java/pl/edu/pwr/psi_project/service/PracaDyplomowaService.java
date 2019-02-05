package pl.edu.pwr.psi_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwr.psi_project.model.PracaDyplomowa;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.model.Student;
import pl.edu.pwr.psi_project.repository.PracaDyplomowaRepository;
import pl.edu.pwr.psi_project.repository.PracownikRepository;
import pl.edu.pwr.psi_project.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PracaDyplomowaService {
    @Autowired
    private PracaDyplomowaRepository pracaDyplomowaRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PracownikRepository pracownikRepository;

    public List<PracaDyplomowa> getAll(){
        return pracaDyplomowaRepository.findAll();
    }

    public List<PracaDyplomowa> getAllPracyZRecenzentamiZaproponowanych(){
        return pracaDyplomowaRepository.findAll();
    }

    public PracaDyplomowa getById(long id){
        return pracaDyplomowaRepository.getOne(id);
    }

    @Transactional
    public PracaDyplomowa save(PracaDyplomowa pracaDyplomowa){
        Optional<Student> studentOptional = studentRepository.findByNrIndeksu(pracaDyplomowa.getStudent().getNrIndeksu());
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            pracaDyplomowa.setStudent(student);
            studentRepository.save(student);
            return pracaDyplomowaRepository.save(pracaDyplomowa);
        }
        else {
            return null;
        }
    }

    public void delete(PracaDyplomowa pracaDyplomowa){
        pracaDyplomowaRepository.delete(pracaDyplomowa);
    }

    public void deleteById(long id){
        PracaDyplomowa pracaDyplomowa = pracaDyplomowaRepository.getOne(id);
        pracaDyplomowaRepository.deleteById(id);
    }

    public PracaDyplomowa update(long id, PracaDyplomowa pracaDyplomowa) {
        PracaDyplomowa pracaDyplomowaOld = getById(id);
        BeanUtils.copyProperties(pracaDyplomowa,pracaDyplomowaOld,"id");
        return save(pracaDyplomowaOld);
    }

    public PracaDyplomowa zaproponujRecenzenta(PracaDyplomowa pracaDyplomowa) {

        if(pracaDyplomowa.getId() > 0) {
            PracaDyplomowa pracaDyplomowaOld = getById(pracaDyplomowa.getId());
            pracaDyplomowa.getRecenzenci().forEach(
                    e -> {
                        Pracownik pracownik = pracownikRepository.getOne(e.getId());
                        pracaDyplomowaOld.getRecenzenci().add(pracownik);
                    }
            );
            System.out.println(">>>> SALVOU O TRABALHO");
            return save(pracaDyplomowaOld);
        }
        System.out.println(">>>> NAO EXISTE O TRABALHO");
        return null;
    }

    public List<PracaDyplomowa> getAllDoRecenzji(){
        return pracaDyplomowaRepository.findAll()
                .stream()
                .filter(e -> e.getRecenzenci().isEmpty()).collect(Collectors.toList());
    }
}
