package com.example.demo.dto.userDto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El nombre es obligatorio")
    @Email(message = "Formato de email invalido")
    private String email;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 18, message = "La edad minima es 18")
    @Max(value = 120, message = "La edad maxima es 120")
    private int edad;
}
