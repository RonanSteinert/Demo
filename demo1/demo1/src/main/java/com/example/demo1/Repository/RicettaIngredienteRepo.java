package com.example.demo1.Repository;

import com.example.demo1.Model.RicettaIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RicettaIngredienteRepo extends JpaRepository<RicettaIngrediente, Long> {

    List<RicettaIngrediente> findByRicetta_IdRicetta(Long idRicetta);

    List<RicettaIngrediente> findByIngrediente_IdIngrediente(Long idIngrediente);

}
