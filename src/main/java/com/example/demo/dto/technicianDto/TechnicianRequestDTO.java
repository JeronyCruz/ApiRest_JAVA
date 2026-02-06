package com.example.demo.dto.technicianDto;

import com.example.demo.models.TechnicianType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class TechnicianRequestDTO {
    private String nameTechnician;
    private UUID technicianTypeId;
    private float hourSalary;
}
