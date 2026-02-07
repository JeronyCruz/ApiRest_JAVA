package com.example.demo.services.impl;

import com.example.demo.dto.technicianTypeDto.TechnicianTypeRequestDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeResponseDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.TechnicianTypeMapper;
import com.example.demo.models.TechnicianType;
import com.example.demo.repository.TechnicianTypeRepository;
import com.example.demo.services.TechnicianTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TechnicianTypeServiceImpl implements TechnicianTypeService {
    private final TechnicianTypeRepository technicianTypeRepository;

    public TechnicianTypeServiceImpl(TechnicianTypeRepository technicianTypeRepository) {
        this.technicianTypeRepository = technicianTypeRepository;
    }

    @Override
    public TechnicianTypeResponseDTO insertTechnicianType(TechnicianTypeRequestDTO dto){
        TechnicianType technicianType = TechnicianTypeMapper.toEntity(dto);
        TechnicianType technicianTypeSaved = technicianTypeRepository.save(technicianType);
        return TechnicianTypeMapper.toDto(technicianTypeSaved);
    }

    @Override
    public List<TechnicianTypeResponseDTO> listTechnicianType() {
        return technicianTypeRepository.findAll()
                .stream()
                .map(TechnicianTypeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TechnicianTypeResponseDTO getTechnicianTypeById(UUID id) {
        TechnicianType technicianType = technicianTypeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tipo Tecnico no encontrado con id: " + id)
                );

        return TechnicianTypeMapper.toDto(technicianType);
    }

    @Override
    public TechnicianTypeResponseDTO updateTechnicianType(UUID id, TechnicianTypeRequestDTO dto) {
        TechnicianType technicianType = technicianTypeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tipo Tecnico no encontrado con id: " + id)
                );

        // actualizar campos
        technicianType.setDescription(dto.getDescription());

        TechnicianType updateTechnicianType = technicianTypeRepository.save(technicianType);
        return TechnicianTypeMapper.toDto(updateTechnicianType);
    }

    @Override
    public void deleteTechnicianType(UUID id) {
        if (!technicianTypeRepository.existsById(id)) {
            throw new RuntimeException("Tipo Tecnico no encontrado con id: " + id);
        }
        technicianTypeRepository.deleteById(id);
    }
}
