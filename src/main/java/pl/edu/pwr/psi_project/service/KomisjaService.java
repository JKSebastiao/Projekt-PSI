package pl.edu.pwr.psi_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwr.psi_project.model.KomisjaEgzaminacyjna;
import pl.edu.pwr.psi_project.model.KomisjaPracownik;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.model.enumerations.StanowiskoPracownika;
import pl.edu.pwr.psi_project.repository.KomisjaPracownikRepository;
import pl.edu.pwr.psi_project.repository.KomisjaRepository;
import pl.edu.pwr.psi_project.repository.PracownikRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KomisjaService {
    @Autowired
    private KomisjaRepository komisjaRepository;

    @Autowired
    private PracownikRepository pracownikRepository;

    @Autowired
    private KomisjaPracownikRepository komisjaPracownikRepository;

    public List<KomisjaEgzaminacyjna> getAll(){
        return komisjaRepository.findAll();
    }

    public KomisjaEgzaminacyjna getById(long id){
        return komisjaRepository.getOne(id);
    }

    @Transactional
    public KomisjaEgzaminacyjna save(KomisjaEgzaminacyjna komisjaEgzaminacyjna){

        if(!sprawdzaKomisje(komisjaEgzaminacyjna)) {
            return null;
        }
        final KomisjaEgzaminacyjna komisja =komisjaRepository.save(komisjaEgzaminacyjna);
        komisjaEgzaminacyjna.getCzlonki().forEach(e -> saveKomisjaPracownik(e,komisja.getId()));
        return  komisjaEgzaminacyjna;
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

    private void saveKomisjaPracownik(KomisjaPracownik komisjaPracownik, long komisjaID){

        Pracownik pracownik = pracownikRepository.getOne(komisjaPracownik.getPracownik().getId());
        komisjaPracownik.setPracownik(pracownik);

        KomisjaEgzaminacyjna komisja = komisjaRepository.getOne(komisjaID);
        komisjaPracownik.setKomisjaEgzaminacyjna(komisja);
        komisjaPracownikRepository.save(komisjaPracownik);
    }

    private boolean sprawdzaPrzewodniczacy(KomisjaEgzaminacyjna komisja){
        for (KomisjaPracownik e : komisja.getCzlonki()){
            if(e.getRola().equals("Przewodniczący")){
                if(e.getPracownik().getTytul().getOrde() > 6 || e.getPracownik().getStanowiskoPracownika() == StanowiskoPracownika.DOCENT){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean sprawdzaCzlonki(KomisjaEgzaminacyjna komisja){
        for(KomisjaPracownik kp: komisja.getCzlonki()) {
            Optional<List<KomisjaPracownik>> optionalKomisjaPracownici = komisjaPracownikRepository.findAllByPracownik(kp.getPracownik());
            if (optionalKomisjaPracownici.isPresent()) {
                for (KomisjaPracownik e : optionalKomisjaPracownici.get()) {
                    if (e.getKomisjaEgzaminacyjna().getDate().equals(komisja.getDate())) {
                        int diff = Math.abs(e.getKomisjaEgzaminacyjna().getTime().getHour() - komisja.getTime().getHour());
                        if (diff <= 5) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean sprawdzaKomisje(KomisjaEgzaminacyjna komisja){
        if(sprawdzaPrzewodniczacy(komisja)&& sprawdzaCzlonki(komisja))
            return true;

        return false;
    }
}
