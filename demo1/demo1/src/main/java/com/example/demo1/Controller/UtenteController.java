package com.example.demo1.Controller;

import com.example.demo1.Model.Utente;
import com.example.demo1.Service.impl.UtenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    private AuthenticationManager authenticationManager;
    private final UtenteServiceImpl utenteService;
    @Autowired
    public UtenteController(AuthenticationManager authenticationManager, UtenteServiceImpl utenteService) {
        this.authenticationManager = authenticationManager;
        this.utenteService = utenteService;
    }

    private boolean isUserAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authentication != null && authentication.isAuthenticated();
    }

    /*@GetMapping("/checkAuthentication")
    public String checkAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            return "L'utente è autenticato!";
        } else {
            return "L'utente non è autenticato.";
        }
    }*/

    @GetMapping("/utenti")
    public ResponseEntity<List<Utente>> getAllUtenti() {

        boolean x = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityContextHolder.getContext().setAuthentication(authentication);

        try {
            List<Utente> utenti = utenteService.getAllUtenti();

            if (utenti == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(utenti, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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




