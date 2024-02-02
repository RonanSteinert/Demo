package com.example.demo1.Controller;

import com.example.demo1.Model.Ricetta;
import com.example.demo1.Model.Utente;
import com.example.demo1.Service.RicettaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/ricetta")
public class RicettaController {

    private final RicettaService ricettaService;

    @Autowired
    public RicettaController(RicettaService ricettaService) {
        this.ricettaService = ricettaService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Ricetta>> getAllRicette() {
        try {
            List<Ricetta> ricetta = ricettaService.getAllRicette();
            return new ResponseEntity<>(ricetta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ricetta> getRicettaById(@PathVariable Long id) {
        Optional<Ricetta> ricetta = ricettaService.getRicettaById(id);
        return ricetta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Ricetta> saveRicetta(@RequestBody Ricetta ricetta) {
        try {
            Ricetta savedRicetta = ricettaService.saveRicetta(ricetta);
            return new ResponseEntity<>(savedRicetta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRicetta(@PathVariable Long id) {

        try{
            ricettaService.deleteRicettaById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("Errore durante eliminazione della ricetta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
