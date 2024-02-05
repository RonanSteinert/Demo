package com.example.demo1.Service.impl;

import com.example.demo1.Model.Ricetta;
import com.example.demo1.Repository.RicettaRepo;
import com.example.demo1.Service.RicettaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RicettaServiceImpl implements RicettaService {

    private final RicettaRepo ricettaRepo;

    @Autowired
    public RicettaServiceImpl(RicettaRepo ricettaRepo) {
        this.ricettaRepo = ricettaRepo;
    }

    @Override
    public Optional<Ricetta> getRicettaByTitolo(String titolo) {
        return Optional.empty();
    }

    @Override
    public List<Ricetta> getAllRicette() {
        return ricettaRepo.findAll();
    }

    @Override
    public Optional<Ricetta> getRicettaById(Long id) {
        return ricettaRepo.findById(id);
    }

    @Override
    public Ricetta saveRicetta(Ricetta ricetta) {
        return ricettaRepo.save(ricetta);
    }

    @Override
    public void deleteRicettaById(Long id) {
        ricettaRepo.deleteById(id);
    }
}
