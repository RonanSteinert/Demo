package com.example.demo1.Service;

import com.example.demo1.Model.Ingrediente;
import com.example.demo1.Model.Preferiti;

import java.util.List;
import java.util.Optional;

public interface PreferitiService {
    List<Preferiti> getAllPreferiti();

    Optional<Ingrediente> getIngredienteById(Long id);

    Ingrediente saveIngrediente(Ingrediente ingrediente);

    void deleteIngredienteById(Long id);
}
