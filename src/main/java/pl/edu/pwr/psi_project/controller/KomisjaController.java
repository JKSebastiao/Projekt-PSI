package pl.edu.pwr.psi_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.psi_project.model.KomisjaEgzaminacyjna;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.service.KomisjaService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/komisji")
public class KomisjaController {

    @Autowired
    private KomisjaService komisjaService;

    @GetMapping
    public ResponseEntity<List<KomisjaEgzaminacyjna>> Komisji(){
        List<KomisjaEgzaminacyjna> komisjaEgzaminacyjnaList = komisjaService.getAll();
        return ResponseEntity.ok(komisjaEgzaminacyjnaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KomisjaEgzaminacyjna> getById(@PathVariable long id){
        KomisjaEgzaminacyjna komisjaEgzaminacyjna = komisjaService.getById(id);
        return komisjaEgzaminacyjna != null ? ResponseEntity.ok(komisjaEgzaminacyjna) : ResponseEntity.notFound().<KomisjaEgzaminacyjna>build();
    }

    @PostMapping
    public ResponseEntity<KomisjaEgzaminacyjna> otworzyc(@Valid @RequestBody KomisjaEgzaminacyjna komisjaEgzaminacyjna, HttpServletResponse response){
        KomisjaEgzaminacyjna komisjaEgzaminacyjnaOld = komisjaService.save(komisjaEgzaminacyjna);
        return ResponseEntity.status(HttpStatus.CREATED).body(komisjaEgzaminacyjna);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KomisjaEgzaminacyjna> update(@PathVariable long id, @Valid @RequestBody KomisjaEgzaminacyjna komisjaEgzaminacyjna){
        KomisjaEgzaminacyjna pracownikAktualny = komisjaService.update(id,komisjaEgzaminacyjna);
        return ResponseEntity.ok(pracownikAktualny);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        komisjaService.deleteById(id);
    }
}
