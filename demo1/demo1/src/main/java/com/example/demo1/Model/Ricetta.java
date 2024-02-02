package com.example.demo1.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Ricette")
public class Ricetta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ricetta")
    private Long idRicetta;

    private String titolo;
    private String descrizione;
    private String istruzioni;
    private int tempoPreparazione;
    private String livelloDifficolta;
    private int numeroPorzioni;

    @ManyToOne
    @JoinColumn(name = "ID_utente")
    private Utente utente;

    // Getters e setters
}
