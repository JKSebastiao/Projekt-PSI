package pl.edu.pwr.psi_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.psi_project.model.Promotor;
import pl.edu.pwr.psi_project.service.PromotorService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/promotorze")
public class PromotorController {

    @Autowired
    private PromotorService PromotorService;

    @GetMapping
    public ResponseEntity<List<Promotor>> Promotorze(){
        List<Promotor> promotorList = PromotorService.getAll();
        return ResponseEntity.ok(promotorList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotor> getById(@PathVariable long id){
        Promotor promotor = PromotorService.getById(id);
        return promotor != null ? ResponseEntity.ok(promotor) : ResponseEntity.notFound().<Promotor>build();
    }

    @PostMapping
    public ResponseEntity<Promotor> otworzyc(@Valid @RequestBody Promotor promotor, HttpServletResponse response){
        Promotor promotorZapisany = PromotorService.save(promotor);
        return ResponseEntity.status(HttpStatus.CREATED).body(promotor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promotor> update(@PathVariable long id, @Valid @RequestBody Promotor promotor){
        Promotor promotorAktualny = PromotorService.update(id,promotor);
        return ResponseEntity.ok(promotorAktualny);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        PromotorService.deleteById(id);
    }
}
