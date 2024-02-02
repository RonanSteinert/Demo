package com.example.demo1.Controller;

import com.example.demo1.Model.RicettaIngrediente;
import com.example.demo1.Service.impl.RicettaIngredienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ricetta-ingredienti")
public class RicettaIngredientiController {

    private final RicettaIngredienteServiceImpl ricettaIngredienteService;
    @Autowired
    public RicettaIngredientiController(RicettaIngredienteServiceImpl ricettaIngredienteService) {
        this.ricettaIngredienteService = ricettaIngredienteService;
    }

    @GetMapping("/ricetta/{ricettaId}")
    public ResponseEntity<List<RicettaIngrediente>> getRicettaIngredienti(@PathVariable Long ricettaId) {
        try {
            List<RicettaIngrediente> ingredienti = ricettaIngredienteService.findByRicettaId(ricettaId);
            return new ResponseEntity<>(ingredienti, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/ingrediente/{ingredienteId}")
    public ResponseEntity<List<RicettaIngrediente>> getIngredienteRicette(@PathVariable Long ingredienteId) {
        try {
            List<RicettaIngrediente> ricette = ricettaIngredienteService.findByIngredienteId(ingredienteId);
            return new ResponseEntity<>(ricette, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/save/ricetta-ingrediente")
    public ResponseEntity<Void> saveRicettaIngrediente(@RequestBody RicettaIngrediente ricettaIngrediente) {
        try {
            ricettaIngredienteService.saveRicettaIngrediente(ricettaIngrediente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/ricetta/{ricettaId}")
    public ResponseEntity<String> deleteRicettaIngredienti(@PathVariable Long ricettaId) {
        try {
            ricettaIngredienteService.deleteByRicettaId(ricettaId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("Errore durante eliminazione ricetta",HttpStatus.NOT_FOUND);
        }

    }


}
