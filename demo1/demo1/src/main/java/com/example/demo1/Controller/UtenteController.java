package com.example.demo1.Controller;

import com.example.demo1.Model.Utente;
import com.example.demo1.Service.impl.UtenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/utenti")
public class UtenteController {

    private final UtenteServiceImpl utenteService;

    @Autowired
    public UtenteController(UtenteServiceImpl utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Utente>> getAllUtenti() {
        try {
            List<Utente> utenti = utenteService.getAllUtenti();
            return new ResponseEntity<>(utenti, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utente> getUtenteById(@PathVariable Long id) {
        Optional<Utente> utente = utenteService.getUtenteById(id);
        return utente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Utente> saveUtente(@RequestBody Utente utente) {
        try {
            Utente savedUtente = utenteService.saveUtente(utente);
            return new ResponseEntity<>(savedUtente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUtente(@PathVariable Long id) {

        try{
            utenteService.deleteUtenteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("Errore durante eliminazione dell'utente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}




