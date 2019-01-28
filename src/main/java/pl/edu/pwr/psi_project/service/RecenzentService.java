package pl.edu.pwr.psi_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwr.psi_project.model.PracaDyplomowa;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.model.Recenzent;
import pl.edu.pwr.psi_project.repository.PracaDyplomowaRepository;
import pl.edu.pwr.psi_project.repository.PracownikRepository;
import pl.edu.pwr.psi_project.repository.RecenzentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecenzentService {
    @Autowired
    private RecenzentRepository recenzentRepository;

    @Autowired
    private PracownikRepository pracownikRepository;

    @Autowired
    private PracaDyplomowaService pracaDyplomowaService;

    public List<Recenzent> getAll(){
        return recenzentRepository
                .findAll()
                .stream()
                .filter(e -> e.isPowolany() == false)
                .collect(Collectors.toList());
    }

    public Recenzent getById(long id){
        return recenzentRepository.getOne(id);
    }

    @Transactional
    public Recenzent save(Recenzent recenzent){
        Pracownik pracownik = pracownikRepository
                .getOne(recenzent.getPracownik().getId());
        Optional<Recenzent> recenzentOptional = recenzentRepository.findByPracownik(pracownik);
        if(recenzentOptional.isPresent()){
            Recenzent oldRecenzent = recenzentOptional.get();

            recenzent.getListaPracyDyplomowych().forEach(e ->{
                PracaDyplomowa pracaDyplomowa = pracaDyplomowaService.getById(e.getId());
                pracaDyplomowa.setRecenzent(oldRecenzent);
                pracaDyplomowaService.update(pracaDyplomowa.getId(),pracaDyplomowa);
            });
            return recenzentRepository.save(oldRecenzent);
        }
        recenzent.setPracownik(pracownik);
        Recenzent recenzentSaved = recenzentRepository.save(recenzent);
        recenzent.getListaPracyDyplomowych().forEach(e ->{
            PracaDyplomowa pracaDyplomowa = pracaDyplomowaService.getById(e.getId());
            pracaDyplomowa.setRecenzent(recenzentSaved);
            pracaDyplomowaService.update(pracaDyplomowa.getId(),pracaDyplomowa);
        });
        return recenzentSaved;
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
        recenzentOld.setPowolany(true);
        //BeanUtils.copyProperties(recenzent,recenzentOld,"id","listaPracyDyplomowych");
        return save(recenzentOld);
    }

    public List<Recenzent> getAllRecenzenci() {
        return recenzentRepository
                .findAll()
                .stream()
                .filter(e -> e.isPowolany() == true)
                .collect(Collectors.toList());
    }
}
