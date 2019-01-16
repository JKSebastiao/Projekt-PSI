package pl.edu.pwr.psi_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.psi_project.model.KomisjaEgzaminacyjna;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.repository.KomisjaRepository;

import java.util.List;

@Service
public class KomisjaService {
    @Autowired
    private KomisjaRepository komisjaRepository;

    public List<KomisjaEgzaminacyjna> getAll(){
        return komisjaRepository.findAll();
    }

    public KomisjaEgzaminacyjna getById(long id){
        return komisjaRepository.getOne(id);
    }

    public KomisjaEgzaminacyjna save(KomisjaEgzaminacyjna komisjaEgzaminacyjna){
        return komisjaRepository.save(komisjaEgzaminacyjna);
    }

    public void delete(KomisjaEgzaminacyjna komisjaEgzaminacyjna){
        komisjaRepository.delete(komisjaEgzaminacyjna);
    }

    public void deleteById(long id){
        KomisjaEgzaminacyjna komisjaEgzaminacyjna = komisjaRepository.getOne(id);
        komisjaRepository.deleteById(id);
    }

    public KomisjaEgzaminacyjna update(long id, KomisjaEgzaminacyjna komisjaEgzaminacyjna) {

        KomisjaEgzaminacyjna komisjaEgzaminacyjnaOld = getById(id);
        BeanUtils.copyProperties(komisjaEgzaminacyjna,komisjaEgzaminacyjnaOld,"id");
        return save(komisjaEgzaminacyjnaOld);
    }
}
