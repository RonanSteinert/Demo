package com.example.demo1.Service.impl;

import com.example.demo1.Model.RicettaIngrediente;
import com.example.demo1.Repository.RicettaIngredienteRepo;
import com.example.demo1.Service.RicettaIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RicettaIngredienteServiceImpl implements RicettaIngredienteService {

    private final RicettaIngredienteRepo ricettaIngredienteRepo;
    @Autowired
    public RicettaIngredienteServiceImpl(RicettaIngredienteRepo ricettaIngredienteRepo) {
        this.ricettaIngredienteRepo = ricettaIngredienteRepo;
    }

    @Override
    public List<RicettaIngrediente> findByRicettaId(Long ricettaId) {
        return ricettaIngredienteRepo.findByRicetta_IdRicetta(ricettaId);
    }

    @Override
    public List<RicettaIngrediente> findByIngredienteId(Long ingredienteId) {
        return ricettaIngredienteRepo.findByIngrediente_IdIngrediente(ingredienteId);
    }

    @Override
    public RicettaIngrediente saveRicettaIngrediente(RicettaIngrediente ricettaIngrediente) {
        return ricettaIngredienteRepo.save(ricettaIngrediente);
    }

    @Override
    public void deleteByRicettaId(Long ricettaId) {
        ricettaIngredienteRepo.deleteById(ricettaId);
    }
}
