package com.example.demo1.Repository;

import com.example.demo1.Model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepo extends JpaRepository<Ingrediente, Long> {
}
