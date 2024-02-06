package com.example.demo1.Service.impl;

import com.example.demo1.Model.Utente;
import com.example.demo1.Repository.UtenteRepo;
import com.example.demo1.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UtenteServiceImpl implements UtenteService {

    private final UtenteRepo utenteRepo;
    @Autowired
    public UtenteServiceImpl(UtenteRepo utenteRepo) {
        this.utenteRepo = utenteRepo;
    }

    @Override
    public List<Utente> getAllUtenti() {
        return utenteRepo.findAll();
    }

    @Override
    public Optional<Utente> getUtenteById(Long id) {
        return utenteRepo.findById(id);
    }


    @Override
    public Optional<Utente> findByUsername(String userName) {
        return utenteRepo.findByUsername(userName);
    }

    @Override
    public Optional<Utente> findByUsernameOrEmail(String userName) {
        return utenteRepo.findByEmail(userName);
    }

    @Override
    public Optional<Utente> findByEmail(String email) {
        return utenteRepo.findByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return utenteRepo.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return utenteRepo.existsByEmail(email);
    }

    @Override
    public Utente saveUtente(Utente utente) {
        return utenteRepo.save(utente);
    }

    @Override
    public void deleteUtenteById(Long id) {
        utenteRepo.deleteById(id);
    }
}
