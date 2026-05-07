package com.example.demo.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String nombre;
    private String email;
    private String password;
    private int edad;
}
