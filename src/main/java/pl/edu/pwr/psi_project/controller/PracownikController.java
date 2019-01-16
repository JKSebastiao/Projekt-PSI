package pl.edu.pwr.psi_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.psi_project.model.Pracownik;
import pl.edu.pwr.psi_project.service.PracownikService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pracowniki")
public class PracownikController {

    @Autowired
    private PracownikService pracownikService;

    @GetMapping
    public ResponseEntity<List<Pracownik>> pracowniki(){
        List<Pracownik> pracownikList = pracownikService.getAll();
        return ResponseEntity.ok(pracownikList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pracownik> getById(@PathVariable long id){
        Pracownik pracownik = pracownikService.getById(id);
        return pracownik != null ? ResponseEntity.ok(pracownik) : ResponseEntity.notFound().<Pracownik>build();
    }

    @PostMapping
    public ResponseEntity<Pracownik> otworzyc(@Valid @RequestBody Pracownik pracownik, HttpServletResponse response){
        Pracownik pracownikZapisany = pracownikService.save(pracownik);
        return ResponseEntity.status(HttpStatus.CREATED).body(pracownik);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pracownik> update(@PathVariable long id, @Valid @RequestBody Pracownik pracownik){
        Pracownik pracownikAktualny = pracownikService.update(id,pracownik);
        return ResponseEntity.ok(pracownikAktualny);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        pracownikService.deleteById(id);
    }
}
