package com.example.demo.services;

import com.example.demo.dto.technicianTypeDto.TechnicianTypeRequestDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeResponseDTO;

import java.util.List;

public interface TechnicianTypeService {
    TechnicianTypeResponseDTO insertTechnicianType(TechnicianTypeRequestDTO dto);
    List<TechnicianTypeResponseDTO> listTechnicianType();
}
