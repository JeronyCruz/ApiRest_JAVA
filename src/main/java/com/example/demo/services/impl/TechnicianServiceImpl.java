package com.example.demo.services.impl;

import com.example.demo.dto.technicianDto.TechnicianRequestDTO;
import com.example.demo.dto.technicianDto.TechnicianResponseDTO;
import com.example.demo.mapper.TechnicianMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.Technician;
import com.example.demo.models.TechnicianType;
import com.example.demo.repository.TechnicianRepository;
import com.example.demo.repository.TechnicianTypeRepository;
import com.example.demo.services.TechnicianService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicianServiceImpl implements TechnicianService {
    private final TechnicianRepository technicianRepository;
    private final TechnicianTypeRepository technicianTypeRepository;


    public TechnicianServiceImpl(TechnicianRepository technicianRepository, TechnicianTypeRepository technicianTypeRepository) {
        this.technicianRepository = technicianRepository;
        this.technicianTypeRepository = technicianTypeRepository;
    }

    @Override
    public TechnicianResponseDTO insertTechnician(TechnicianRequestDTO dto){
        Technician technician = TechnicianMapper.toEntity(dto);
        TechnicianType type = technicianTypeRepository
                .findById(dto.getTechnicianTypeId())
                .orElseThrow(() ->
                        new RuntimeException("Technician type not found"));

        technician.setTechnicianType(type);
        Technician technicianSaved = technicianRepository.save(technician);
        return TechnicianMapper.toDto(technicianSaved);
    }

    @Override
    public List<TechnicianResponseDTO> listTechnician() {
        return technicianRepository.findAll()
                .stream()
                .map(TechnicianMapper::toDto)
                .collect(Collectors.toList());
    }

}
