package com.example.demo1.Controller;

import com.example.demo1.Model.Ingrediente;
import com.example.demo1.Model.Utente;
import com.example.demo1.Service.impl.IngredienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

    private final IngredienteServiceImpl ingredienteService;

    @Autowired
    public IngredienteController(IngredienteServiceImpl ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ingrediente>> getAllIngredienti() {
        try {
            List<Ingrediente> ingredienti = ingredienteService.getAllIngredienti();
            return new ResponseEntity<>(ingredienti, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> getIngredienteById(@PathVariable Long id) {
        Optional<Ingrediente> ingrediente = ingredienteService.getIngredienteById(id);
        return ingrediente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Ingrediente> saveIngrediente(@RequestBody Ingrediente ingrediente) {
        try {
            Ingrediente savedIngrediente = ingredienteService.saveIngrediente(ingrediente);
            return new ResponseEntity<>(savedIngrediente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIngrediente(@PathVariable Long id) {

        try{
            ingredienteService.deleteIngredienteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("Errore durante eliminazione dell'ingrediente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
