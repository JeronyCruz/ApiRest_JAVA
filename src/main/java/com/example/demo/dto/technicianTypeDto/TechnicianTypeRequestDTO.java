package com.example.demo.dto.technicianTypeDto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class TechnicianTypeRequestDTO {
    private String description;
}
