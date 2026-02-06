package com.example.demo.mapper;

import com.example.demo.dto.technicianTypeDto.TechnicianTypeRequestDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeResponseDTO;
import com.example.demo.models.TechnicianType;

public class TechnicianTypeMapper {
    public static TechnicianType toEntity(TechnicianTypeRequestDTO dto){
        TechnicianType technicianType = new TechnicianType();
        technicianType.setDescription(dto.getDescription());
        return technicianType;
    }

    public static TechnicianTypeResponseDTO toDto(TechnicianType technicianType){
        TechnicianTypeResponseDTO dto = new TechnicianTypeResponseDTO();
        dto.setTechnicianTypeId(technicianType.getTechnicianTypeId());
        dto.setDescription(technicianType.getDescription());
        dto.setDate(technicianType.getDate());
        return dto;
    }
}
