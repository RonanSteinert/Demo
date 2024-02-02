package com.example.demo1.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Categorie")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_categoria")
    private Long idCategoria;

    private String nome;
}
