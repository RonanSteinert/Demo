package com.example.demo1.Controller;

import com.example.demo1.Model.Preferiti;
import com.example.demo1.Model.Utente;
import com.example.demo1.Service.impl.PreferitiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/preferiti")
public class PreferitiController {

    private final PreferitiServiceImpl preferitiService;

    @Autowired
    public PreferitiController(PreferitiServiceImpl preferitiService) {
        this.preferitiService = preferitiService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Preferiti>> getAllPreferiti() {
        try {
            List<Preferiti> preferiti = preferitiService.getAllPreferiti();
            return new ResponseEntity<>(preferiti, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Preferiti> getPreferitiById(@PathVariable Long id) {
        Optional<Preferiti> preferito = preferitiService.getPreferitiById(id);
        return preferito.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Preferiti> savePreferiti(@RequestBody Preferiti preferiti) {
        try {
            Preferiti savedPreferiti = preferitiService.savePreferiti(preferiti);
            return new ResponseEntity<>(savedPreferiti, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePreferito(@PathVariable Long id) {

        try{
            preferitiService.deletePreferitiById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("Errore durante eliminazione dell'utente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
