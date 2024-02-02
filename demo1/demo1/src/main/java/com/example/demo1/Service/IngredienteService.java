package com.example.demo1.Service;

import com.example.demo1.Model.Categoria;
import com.example.demo1.Model.Ingrediente;

import java.util.List;
import java.util.Optional;

public interface IngredienteService {

    List<Ingrediente> getAllIngredienti();

    Optional<Ingrediente> getIngredienteById(Long id);

    Ingrediente saveIngrediente(Ingrediente ingrediente);

    void deleteIngredienteById(Long id);
}
