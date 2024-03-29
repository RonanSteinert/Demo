package com.example.demo1.Model;

import com.example.demo1.Model.Enum.Ruolo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_utente")
    private Long idUtente;

    private String nome;

    private String cognome;

    @Column(name = "email")
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;
    public Utente() {

    }
    public Utente(long idUtente, String nome, String cognome, String mail, String pass, Ruolo ruolo) {
    }


}
