package com.example.demo1.Repository;

import com.example.demo1.Model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findByEmail(String email);
    Optional<Utente> findByUsernameOrEmail(String username, String email);
    Optional<Utente> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
