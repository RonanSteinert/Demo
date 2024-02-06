package com.example.demo1.Service;

import com.example.demo1.Model.Utente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UtenteService {
    List<Utente> getAllUtenti();

    Optional<Utente> getUtenteById(Long id);

    Optional<Utente> findByUsername(String nome);

    Optional<Utente> findByUsernameOrEmail(String userName);

    Optional<Utente> findByEmail(String email);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Utente saveUtente(Utente utente);

    void deleteUtenteById(Long id);

}
