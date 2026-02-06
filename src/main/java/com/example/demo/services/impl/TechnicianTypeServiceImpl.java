package com.example.demo.services.impl;

import com.example.demo.dto.technicianDto.TechnicianResponseDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeRequestDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeResponseDTO;
import com.example.demo.mapper.TechnicianMapper;
import com.example.demo.mapper.TechnicianTypeMapper;
import com.example.demo.models.TechnicianType;
import com.example.demo.repository.TechnicianRepository;
import com.example.demo.repository.TechnicianTypeRepository;
import com.example.demo.services.TechnicianTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
