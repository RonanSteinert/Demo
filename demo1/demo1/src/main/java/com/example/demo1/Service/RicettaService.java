package com.example.demo1.Service;

import com.example.demo1.Model.Ricetta;

import java.util.List;
import java.util.Optional;

public interface RicettaService {

    Optional<Ricetta> getRicettaByTitolo(String titolo);
    List<Ricetta> getAllRicette();

    Optional<Ricetta> getRicettaById(Long id);

    Ricetta saveRicetta(Ricetta ricetta);

    void deleteRicettaById(Long id);
}
