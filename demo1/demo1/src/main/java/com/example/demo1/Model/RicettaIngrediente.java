package com.example.demo1.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RicettaIngredienti")
public class RicettaIngrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ricetta_ingrediente")
    private Long idRicettaIngrediente;

    @ManyToOne
    @JoinColumn(name = "ID_ricetta")
    private Ricetta ricetta;

    @ManyToOne
    @JoinColumn(name = "ID_ingrediente")
    private Ingrediente ingrediente;

    private double quantita;
    private String unitaMisura;
}
