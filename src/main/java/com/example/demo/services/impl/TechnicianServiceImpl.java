package com.example.demo.services.impl;

import com.example.demo.dto.technicianDto.TechnicianRequestDTO;
import com.example.demo.dto.technicianDto.TechnicianResponseDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeRequestDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeResponseDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.TechnicianMapper;
import com.example.demo.mapper.TechnicianTypeMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.Technician;
import com.example.demo.models.TechnicianType;
import com.example.demo.repository.TechnicianRepository;
import com.example.demo.repository.TechnicianTypeRepository;
import com.example.demo.services.TechnicianService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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

    @Override
    public TechnicianResponseDTO getTechnicianById(UUID id) {
        Technician technician = technicianRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tecnico no encontrado con id: " + id)
                );

        return TechnicianMapper.toDto(technician);
    }

    @Override
    public TechnicianResponseDTO updateTechnician(UUID id, TechnicianRequestDTO dto) {
        Technician technician = technicianRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tecnico no encontrado con id: " + id)
                );

        // actualizar campos
        technician.setNameTechnician(dto.getNameTechnician());
        technician.setHourSalary(dto.getHourSalary());
        technician.setTechnicianId(dto.getTechnicianTypeId());

        Technician updateTechnician = technicianRepository.save(technician);
        return TechnicianMapper.toDto(updateTechnician);
    }

    @Override
    public void deleteTechnician(UUID id) {
        if (!technicianRepository.existsById(id)) {
            throw new RuntimeException("Tecnico no encontrado con id: " + id);
        }
        technicianTypeRepository.deleteById(id);
    }

}
