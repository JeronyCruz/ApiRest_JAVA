package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@Getter
@Setter
@Entity(name = "refresh_tokens")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String token;

    @OneToOne
    private User user;

    private Instant expiryDate;
}
