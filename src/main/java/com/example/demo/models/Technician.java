package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "technician")
public class Technician {
    @Id
    @GeneratedValue
    private UUID technicianId;

    @Column(nullable = false)
    private String nameTechnician;

    @ManyToOne
    @JoinColumn(name = "technicianTypeId")
    private TechnicianType technicianType;

    @Column(nullable = false)
    private float hourSalary;

    @Column(nullable = false)
    private LocalDate date;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDate.now();
    }

}
