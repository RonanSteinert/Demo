package com.example.demo1.Service;

import com.example.demo1.Model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CategoriaService {
    List<Categoria> getAllCategorie();

    Optional<Categoria> getCategoriaById(Long id);

    Categoria saveCategoria(Categoria categoria);

    void deleteCategoriaById(Long id);
}
