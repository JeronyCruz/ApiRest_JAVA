package com.example.demo.controller;

import com.example.demo.dto.technicianDto.TechnicianRequestDTO;
import com.example.demo.dto.technicianDto.TechnicianResponseDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeRequestDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeResponseDTO;
import com.example.demo.services.TechnicianService;
import com.example.demo.services.TechnicianTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technicianType")
public class TechnicianTypeController {
    @Autowired
    private TechnicianTypeService technicianTypeService;

    public TechnicianTypeController(TechnicianTypeService technicianTypeService){
        this.technicianTypeService = technicianTypeService;
    }

    @PostMapping
    public TechnicianTypeResponseDTO postTechnicianType(@RequestBody TechnicianTypeRequestDTO dto){
        return technicianTypeService.insertTechnicianType(dto);
    }

    @GetMapping
    public List<TechnicianTypeResponseDTO> getTechnician(){
        return technicianTypeService.listTechnicianType();
    }
}
