package com.example.demo.dto.technicianDto;

import com.example.demo.models.TechnicianType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@JsonPropertyOrder({ "technicianId", "nameTechnician", "technicianType", "hourSalary", "date" })
public class TechnicianResponseDTO {
    private UUID technicianId;
    private String nameTechnician;
    private float hourSalary;
    private UUID technicianTypeId;
    private LocalDate date;
}
