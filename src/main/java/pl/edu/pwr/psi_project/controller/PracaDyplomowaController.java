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

@RestController
@RequestMapping("/pracy_dyplomowych")
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
    public ResponseEntity<PracaDyplomowa> otworzyc(@Valid @RequestBody PracaDyplomowa pracaDyplomowa, HttpServletResponse response){
        PracaDyplomowa pracaDyplomowaZapisana = PracaDyplomowaService.save(pracaDyplomowa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pracaDyplomowa);
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
}
