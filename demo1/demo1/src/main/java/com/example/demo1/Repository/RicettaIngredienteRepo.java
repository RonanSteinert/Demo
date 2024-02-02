package com.example.demo1.Repository;

import com.example.demo1.Model.RicettaIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RicettaIngredienteRepo extends JpaRepository<RicettaIngrediente, Long> {
}
