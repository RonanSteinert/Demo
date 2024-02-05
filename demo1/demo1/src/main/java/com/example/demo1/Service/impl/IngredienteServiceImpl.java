package com.example.demo1.Service.impl;

import com.example.demo1.Model.Ingrediente;
import com.example.demo1.Repository.IngredienteRepo;
import com.example.demo1.Service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IngredienteServiceImpl implements IngredienteService {

    private final IngredienteRepo ingredienteRepo;

    @Autowired
    public IngredienteServiceImpl(IngredienteRepo ingredienteRepo) {
        this.ingredienteRepo = ingredienteRepo;
    }

    @Override
    public List<Ingrediente> getAllIngredienti() {
        return ingredienteRepo.findAll();
    }

    @Override
    public Optional<Ingrediente> getIngredienteById(Long id) {
        return ingredienteRepo.findById(id);
    }

    @Override
    public Ingrediente saveIngrediente(Ingrediente ingrediente) {
        return ingredienteRepo.save(ingrediente);
    }

    @Override
    public void deleteIngredienteById(Long id) {
        ingredienteRepo.deleteById(id);
    }
}
