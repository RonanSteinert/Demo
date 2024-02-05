package com.example.demo1.Service;

import com.example.demo1.Model.RicettaIngrediente;
import com.example.demo1.Model.Utente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface RicettaIngredienteService {

    List<RicettaIngrediente> findByRicettaId(Long ricettaId);

    List<RicettaIngrediente> findByIngredienteId(Long ingredienteId);

    RicettaIngrediente saveRicettaIngrediente(RicettaIngrediente ricettaIngrediente);

    void deleteByRicettaId(Long ricettaId);

}
