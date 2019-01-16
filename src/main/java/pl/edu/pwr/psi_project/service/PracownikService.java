package pl.edu.pwr.psi_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.repository.PracownikRepository;

import java.util.List;

@Service
public class PracownikService {
    @Autowired
    private PracownikRepository pracownikRepository;

    public List<Pracownik> getAll(){
        return pracownikRepository.findAll();
    }

    public Pracownik getById(long id){
        return pracownikRepository.getOne(id);
    }

    public Pracownik save(Pracownik pracownik){
        return pracownikRepository.save(pracownik);
    }

    public void delete(Pracownik pracownik){
        pracownikRepository.delete(pracownik);
    }

    public void deleteById(long id){
        Pracownik pracownik = pracownikRepository.getOne(id);
        pracownikRepository.deleteById(id);
    }

    public Pracownik update(long id, Pracownik pracownik) {

        Pracownik pracownikOld = getById(id);
        BeanUtils.copyProperties(pracownik,pracownikOld,"id");
        return save(pracownikOld);
    }
}
