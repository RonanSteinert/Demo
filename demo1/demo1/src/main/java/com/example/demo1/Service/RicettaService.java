package com.example.demo1.Service;

import com.example.demo1.Model.Ricetta;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;
import java.util.Optional;
@Service
public interface RicettaService {

    Optional<Ricetta> getRicettaByTitolo(String titolo);
    List<Ricetta> getAllRicette();

    Optional<Ricetta> getRicettaById(Long id);

    Ricetta saveRicetta(Ricetta ricetta);

    void deleteRicettaById(Long id);
}
