package com.example.demo1.Service;

import com.example.demo1.Model.Ingrediente;
import com.example.demo1.Model.Preferiti;
import com.example.demo1.Model.Utente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface PreferitiService {

   // Preferiti getPreferitoByUtente(Utente utente);
    List<Preferiti> getAllPreferiti();

    Optional<Preferiti> getPreferitiById(Long id);

    Preferiti savePreferiti(Preferiti preferiti);

    void deletePreferitiById(Long id);
}
