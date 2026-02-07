package com.example.demo.services;

import com.example.demo.dto.technicianTypeDto.TechnicianTypeRequestDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeResponseDTO;

import java.util.List;
import java.util.UUID;

public interface TechnicianTypeService {
    TechnicianTypeResponseDTO insertTechnicianType(TechnicianTypeRequestDTO dto);
    List<TechnicianTypeResponseDTO> listTechnicianType();
    TechnicianTypeResponseDTO getTechnicianTypeById(UUID id);
    TechnicianTypeResponseDTO updateTechnicianType(UUID id, TechnicianTypeRequestDTO dto);
    void deleteTechnicianType(UUID id);
}
