package com.example.demo1.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Preferiti")
public class Preferiti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_preferito")
    private Long idPreferito;

    @ManyToOne
    @JoinColumn(name = "ID_utente")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "ID_ricetta")
    private Ricetta ricetta;
}
