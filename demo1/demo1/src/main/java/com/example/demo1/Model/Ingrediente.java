package com.example.demo1.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Ingredienti")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ingrediente")
    private Long idIngrediente;

    private String nome;
    private String descrizione;
    private String immagine;
}
