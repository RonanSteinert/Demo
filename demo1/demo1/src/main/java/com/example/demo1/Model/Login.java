package com.example.demo1.Model;


import lombok.Data;

@Data
public class Login {
    private String usernameOrEmail;
    private String password;
}