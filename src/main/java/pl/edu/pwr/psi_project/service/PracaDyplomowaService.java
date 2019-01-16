package pl.edu.pwr.psi_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.psi_project.model.PracaDyplomowa;
import pl.edu.pwr.psi_project.repository.PracaDyplomowaRepository;

import java.util.List;

@Service
public class PracaDyplomowaService {
    @Autowired
    private PracaDyplomowaRepository pracaDyplomowaRepository;

    public List<PracaDyplomowa> getAll(){
        return pracaDyplomowaRepository.findAll();
    }

    public PracaDyplomowa getById(long id){
        return pracaDyplomowaRepository.getOne(id);
    }

    public PracaDyplomowa save(PracaDyplomowa pracaDyplomowa){
        return pracaDyplomowaRepository.save(pracaDyplomowa);
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
}
