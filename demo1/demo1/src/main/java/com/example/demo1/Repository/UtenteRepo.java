package com.example.demo1.Repository;

import com.example.demo1.Model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    Optional<Utente> findByNome(String nome);

    Optional<Utente> findByEmail(String email);
}
