package pl.edu.pwr.psi_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.psi_project.model.Recenzent;
import pl.edu.pwr.psi_project.repository.RecenzentRepository;

import java.util.List;

@Service
public class RecenzentService {
    @Autowired
    private RecenzentRepository recenzentRepository;

    public List<Recenzent> getAll(){
        return recenzentRepository.findAll();
    }

    public Recenzent getById(long id){
        return recenzentRepository.getOne(id);
    }

    public Recenzent save(Recenzent recenzent){
        return recenzentRepository.save(recenzent);
    }

    public void delete(Recenzent recenzent){
        recenzentRepository.delete(recenzent);
    }

    public void deleteById(long id){
        Recenzent recenzent = recenzentRepository.getOne(id);
        recenzentRepository.deleteById(id);
    }

    public Recenzent update(long id, Recenzent recenzent) {

        Recenzent recenzentOld = getById(id);
        BeanUtils.copyProperties(recenzent,recenzentOld,"id");
        return save(recenzentOld);
    }
}
