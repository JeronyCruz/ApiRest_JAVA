package com.example.demo.dto.usuarioDto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({ "id", "nombre", "email", "edad" })
public class UserResponseDTO {
    private int id;
    private String nombre;
    private String email;
    private int edad;
}
