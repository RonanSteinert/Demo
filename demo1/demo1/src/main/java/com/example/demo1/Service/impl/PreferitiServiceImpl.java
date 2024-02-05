package com.example.demo1.Service.impl;

import com.example.demo1.Model.Preferiti;
import com.example.demo1.Model.Utente;
import com.example.demo1.Repository.PreferitiRepo;
import com.example.demo1.Service.PreferitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PreferitiServiceImpl implements PreferitiService {

    private final PreferitiRepo preferitiRepo;

    @Autowired
    public PreferitiServiceImpl(PreferitiRepo preferitiRepo) {
        this.preferitiRepo = preferitiRepo;
    }

 /*   @Override
    public Preferiti getPreferitoByUtente(Utente utente) {
        return
    }*/

    @Override
    public List<Preferiti> getAllPreferiti() {
        return preferitiRepo.findAll();
    }

    @Override
    public Optional<Preferiti> getPreferitiById(Long id) {
        return preferitiRepo.findById(id);
    }

    @Override
    public Preferiti savePreferiti(Preferiti preferiti) {
        return preferitiRepo.save(preferiti);
    }

    @Override
    public void deletePreferitiById(Long id) {
        preferitiRepo.deleteById(id);
    }
}
