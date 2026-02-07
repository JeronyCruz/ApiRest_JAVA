package com.example.demo.services;

import com.example.demo.dto.technicianDto.TechnicianRequestDTO;
import com.example.demo.dto.technicianDto.TechnicianResponseDTO;

import java.util.List;
import java.util.UUID;

public interface TechnicianService {
    TechnicianResponseDTO insertTechnician(TechnicianRequestDTO dto);
    List<TechnicianResponseDTO> listTechnician();
    TechnicianResponseDTO getTechnicianById(UUID id);
    TechnicianResponseDTO updateTechnician(UUID id, TechnicianRequestDTO dto);
    void deleteTechnician(UUID id);
}
