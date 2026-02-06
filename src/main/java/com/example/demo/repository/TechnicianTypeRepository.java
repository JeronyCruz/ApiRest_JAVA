package com.example.demo.repository;

import com.example.demo.models.TechnicianType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TechnicianTypeRepository extends JpaRepository<TechnicianType, UUID> {
}
