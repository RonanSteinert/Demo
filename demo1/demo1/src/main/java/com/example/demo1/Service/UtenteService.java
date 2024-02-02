package com.example.demo1.Service;

import com.example.demo1.Model.Utente;

import java.util.List;
import java.util.Optional;

public interface UtenteService {
    List<Utente> getAllUtenti();

    Optional<Utente> getUtenteById(Long id);

    //Optional<Utente> getUtenteByEmail(String email);

    Utente saveUtente(Utente utente);

    void deleteUtenteById(Long id);

}
