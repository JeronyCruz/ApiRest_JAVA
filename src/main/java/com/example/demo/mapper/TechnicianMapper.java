package com.example.demo.mapper;

import com.example.demo.dto.technicianDto.TechnicianRequestDTO;
import com.example.demo.dto.technicianDto.TechnicianResponseDTO;
import com.example.demo.models.Technician;

public class TechnicianMapper {

    public static Technician toEntity(TechnicianRequestDTO dto){
        Technician technician = new Technician();
        technician.setNameTechnician(dto.getNameTechnician());
        technician.setHourSalary(dto.getHourSalary());
        return technician;
    }

    public static TechnicianResponseDTO toDto(Technician technician){
        TechnicianResponseDTO dto = new TechnicianResponseDTO();
        dto.setTechnicianId(technician.getTechnicianId());
        dto.setNameTechnician(technician.getNameTechnician());
        dto.setHourSalary(technician.getHourSalary());
        dto.setTechnicianTypeId(
                technician.getTechnicianType().getTechnicianTypeId()
        );
        dto.setDate(technician.getDate());
        return dto;
    }
}
