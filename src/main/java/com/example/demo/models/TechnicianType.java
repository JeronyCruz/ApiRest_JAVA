package com.example.demo.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "technicianType")
public class TechnicianType {
    @Id
    @GeneratedValue
    private UUID technicianTypeId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate date;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDate.now();
    }
}
