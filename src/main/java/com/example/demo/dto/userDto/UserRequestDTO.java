package com.example.demo.dto.userDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String nombre;
    private String email;
    private int edad;
}
