package com.example.demo1.Controller;

import com.example.demo1.Model.Categoria;
import com.example.demo1.Model.Utente;
import com.example.demo1.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;
    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Categoria>> getAllCategoria() {
        try {
            List<Categoria> categorie = categoriaService.getAllCategorie();
            return new ResponseEntity<>(categorie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.getCategoriaById(id);
        return categoria.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
        try {
            Categoria savedCategoria = categoriaService.saveCategoria(categoria);
            return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id) {

        try{
            categoriaService.deleteCategoriaById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("Errore durante eliminazione della categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
