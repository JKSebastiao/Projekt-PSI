package pl.edu.pwr.psi_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.psi_project.model.Promotor;
import pl.edu.pwr.psi_project.repository.PromotorRepository;

import java.util.List;

@Service
public class PromotorService {
    @Autowired
    private PromotorRepository promotorRepository;

    public List<Promotor> getAll(){
        return promotorRepository.findAll();
    }

    public Promotor getById(long id){
        return promotorRepository.getOne(id);
    }

    public Promotor save(Promotor promotor){
        return promotorRepository.save(promotor);
    }

    public void delete(Promotor promotor){
        promotorRepository.delete(promotor);
    }

    public void deleteById(long id){
        Promotor promotor = promotorRepository.getOne(id);
        promotorRepository.deleteById(id);
    }

    public Promotor update(long id, Promotor promotor) {

        Promotor promotorOld = getById(id);
        BeanUtils.copyProperties(promotor,promotorOld,"id");
        return save(promotorOld);
    }
}
