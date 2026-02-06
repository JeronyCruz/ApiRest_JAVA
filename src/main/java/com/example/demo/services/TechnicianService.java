package com.example.demo.services;

import com.example.demo.dto.technicianDto.TechnicianRequestDTO;
import com.example.demo.dto.technicianDto.TechnicianResponseDTO;

import java.util.List;

public interface TechnicianService {
    TechnicianResponseDTO insertTechnician(TechnicianRequestDTO dto);
    List<TechnicianResponseDTO> listTechnician();
}
