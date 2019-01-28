package pl.edu.pwr.psi_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.psi_project.model.PracaDyplomowa;
import pl.edu.pwr.psi_project.service.PracaDyplomowaService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/pracy")
public class PracaDyplomowaController {

    @Autowired
    private PracaDyplomowaService PracaDyplomowaService;

    @GetMapping
    public ResponseEntity<List<PracaDyplomowa>> PracaDyplomowai(){
        List<PracaDyplomowa> PracaDyplomowaList = PracaDyplomowaService.getAll();
        return ResponseEntity.ok(PracaDyplomowaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PracaDyplomowa> getById(@PathVariable long id){
        PracaDyplomowa pracaDyplomowa = PracaDyplomowaService.getById(id);
        return pracaDyplomowa != null ? ResponseEntity.ok(pracaDyplomowa) : ResponseEntity.notFound().<PracaDyplomowa>build();
    }

    @PostMapping
    public ResponseEntity<PracaDyplomowa> otworzyc( @RequestBody PracaDyplomowa pracaDyplomowa, HttpServletResponse response){
        PracaDyplomowa pracaDyplomowaZapisana = PracaDyplomowaService.save(pracaDyplomowa);
        if (pracaDyplomowaZapisana != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(pracaDyplomowaZapisana);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PracaDyplomowa> update(@PathVariable long id, @Valid @RequestBody PracaDyplomowa PracaDyplomowa){
        PracaDyplomowa pracaDyplomowaAktualna = PracaDyplomowaService.update(id,PracaDyplomowa);
        return ResponseEntity.ok(pracaDyplomowaAktualna);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        PracaDyplomowaService.deleteById(id);
    }

    @GetMapping("/propozycja/recenzent")
    public ResponseEntity<List<PracaDyplomowa>> pracyZRecenzentamiZaproponowanych(){
        List<PracaDyplomowa> listaPracyZRecenzentamiZaproponowanych =  PracaDyplomowaService
                .getAll()
                .stream()
                .filter(e -> e.getRecenzent() != null && !e.getRecenzent().isPowolany())
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaPracyZRecenzentamiZaproponowanych);
    }

    @GetMapping("/dopropozycja/recenzent")
    public ResponseEntity<List<PracaDyplomowa>> pracyDoZaproponowanychRecezenta(){
        List<PracaDyplomowa> listaPracyZRecenzentamiZaproponowanych =  PracaDyplomowaService
                .getAll()
                .stream()
                .filter(e -> e.getRecenzent() == null)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaPracyZRecenzentamiZaproponowanych);
    }
}
