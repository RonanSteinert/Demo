package com.example.demo1.Model;

import com.example.demo1.Model.Enum.Ruolo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Enumerated(EnumType.STRING)
    @Size(max = 50)
    private Ruolo name;
}