package com.example.demo1.Service.impl;

import com.example.demo1.Model.Categoria;
import com.example.demo1.Repository.CategoriaRepo;
import com.example.demo1.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepo categoriaRepo;
    @Autowired
    public CategoriaServiceImpl(CategoriaRepo categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }

    @Override
    public List<Categoria> getAllCategorie() {
        return categoriaRepo.findAll();
    }

    @Override
    public Optional<Categoria> getCategoriaById(Long id) {
        return categoriaRepo.findById(id);
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepo.save(categoria);
    }

    @Override
    public void deleteCategoriaById(Long id) {
        categoriaRepo.deleteById(id);
    }
}
