package com.example.demo.dto.technicianTypeDto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@JsonPropertyOrder({ "technicianTypeId", "description", "date" })
public class TechnicianTypeResponseDTO {
    private UUID technicianTypeId;
    private String description;
    private LocalDate date;
}
