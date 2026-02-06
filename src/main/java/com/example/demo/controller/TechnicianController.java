package com.example.demo.controller;

import com.example.demo.dto.technicianDto.TechnicianRequestDTO;
import com.example.demo.dto.technicianDto.TechnicianResponseDTO;
import com.example.demo.dto.userDto.UserRequestDTO;
import com.example.demo.dto.userDto.UserResponseDTO;
import com.example.demo.services.TechnicianService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technician")
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;

    public TechnicianController(TechnicianService technicianService){
        this.technicianService = technicianService;
    }

    @PostMapping
    public TechnicianResponseDTO postTechnician(@RequestBody TechnicianRequestDTO dto){
        return technicianService.insertTechnician(dto);
    }

    @GetMapping
    public List<TechnicianResponseDTO> getTechnician(){
        return technicianService.listTechnician();
    }
}
