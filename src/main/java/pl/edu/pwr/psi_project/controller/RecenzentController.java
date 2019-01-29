package pl.edu.pwr.psi_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.psi_project.model.PracaDyplomowa;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.model.Recenzent;
import pl.edu.pwr.psi_project.service.RecenzentService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(" ")
public class RecenzentController {

    @Autowired
    private RecenzentService recenzentService;

    @GetMapping
    public ResponseEntity<List<Recenzent>> getRecenzenci(){
        List<Recenzent> listaRecenzenci = recenzentService.getAllRecenzenci();
        System.out.println(listaRecenzenci);
        return ResponseEntity.ok(listaRecenzenci);
    }

    @GetMapping("/zaproponowane")
    public ResponseEntity<List<Recenzent>> Recenzenci(){
        List<Recenzent> recenzentList = recenzentService.getAll();
        return ResponseEntity.ok(recenzentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recenzent> getById(@PathVariable long id){
        Recenzent recenzent = recenzentService.getById(id);
        return recenzent != null ? ResponseEntity.ok(recenzent) : ResponseEntity.notFound().<Recenzent>build();
    }

    @PostMapping
    public ResponseEntity<Recenzent> otworzyc(@Valid @RequestBody Recenzent recenzent, HttpServletResponse response){
        Recenzent recenzentZapisany = recenzentService.save(recenzent);
        return ResponseEntity.status(HttpStatus.CREATED).body(recenzent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recenzent> update(@PathVariable long id,@RequestBody Recenzent Recenzent){
        Recenzent recenzentAktualny = recenzentService.update(id,Recenzent);
        return ResponseEntity.ok(recenzentAktualny);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        recenzentService.deleteById(id);
    }


}
