package com.example.demo1.Controller;

import com.example.demo1.Configuration.RoleUtils;
import com.example.demo1.Model.Utente;
import com.example.demo1.Service.impl.UtenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    private final RoleUtils roleUtils;

    private final UtenteServiceImpl utenteService;
    @Autowired
    public UtenteController(RoleUtils roleUtils, UtenteServiceImpl utenteService) {
        this.roleUtils = roleUtils;
        this.utenteService = utenteService;
    }

    @GetMapping(value = "/admin/utenti", produces = "application/json")
    public ResponseEntity<List<Utente>> getAllUtenti() {
            if (roleUtils.hasRole("ADMIN")){
            List<Utente> utenti = utenteService.getAllUtenti();
            return new ResponseEntity<>(utenti, HttpStatus.OK);}
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/dettaglio")
    public ResponseEntity<Utente> getUtenteById(@PathVariable Long id) {

        Optional<Utente> utente = utenteService.getUtenteById(id);
        return utente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/utente/save")
    public ResponseEntity<Utente> saveUtente(@RequestBody Utente utente) {
        try {
            Utente savedUtente = utenteService.saveUtente(utente);
            return new ResponseEntity<>(savedUtente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUtente(@PathVariable Long id) {

        try{
            utenteService.deleteUtenteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("Errore durante eliminazione dell'utente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}




