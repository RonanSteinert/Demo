package com.example.demo1.Service;

import com.example.demo1.Model.Categoria;
import com.example.demo1.Model.Ingrediente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IngredienteService {

    List<Ingrediente> getAllIngredienti();

    Optional<Ingrediente> getIngredienteById(Long id);

    Ingrediente saveIngrediente(Ingrediente ingrediente);

    void deleteIngredienteById(Long id);
}
