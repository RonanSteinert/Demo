package com.example.demo1.Service.impl;

import com.example.demo1.Model.Utente;
import com.example.demo1.Repository.UtenteRepository;
import com.example.demo1.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UtenteServiceImpl implements UtenteService {

    private final UtenteRepository utenteRepository;
    @Autowired
    public UtenteServiceImpl(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    @Override
    public Optional<Utente> getUtenteById(Long id) {
        return utenteRepository.findById(id);
    }


    @Override
    public Optional<Utente> findByUsername(String userName) {
        return utenteRepository.findByUsername(userName);
    }

    @Override
    public Optional<Utente> findByUsernameOrEmail(String userName) {
        return utenteRepository.findByEmail(userName);
    }

    @Override
    public Optional<Utente> findByEmail(String email) {
        return utenteRepository.findByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return utenteRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return utenteRepository.existsByEmail(email);
    }

    @Override
    public Utente saveUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    @Override
    public void deleteUtenteById(Long id) {
        utenteRepository.deleteById(id);
    }
}
