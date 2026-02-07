package com.example.demo.controller;

import com.example.demo.dto.common.Response;
import com.example.demo.dto.technicianDto.TechnicianRequestDTO;
import com.example.demo.dto.technicianDto.TechnicianResponseDTO;
import com.example.demo.dto.userDto.UserRequestDTO;
import com.example.demo.dto.userDto.UserResponseDTO;
import com.example.demo.models.Technician;
import com.example.demo.services.TechnicianService;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/technician")
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;

    public TechnicianController(TechnicianService technicianService){
        this.technicianService = technicianService;
    }

    @PostMapping
    public ResponseEntity<Response<TechnicianResponseDTO>> postTechnician(@Valid @RequestBody TechnicianRequestDTO dto){

        TechnicianResponseDTO technician = technicianService.insertTechnician(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>(
                true,
                "Tecnico creado correctamente",
                technician
        ));

    }

    @GetMapping
    public List<TechnicianResponseDTO> getTechnician(){
        return technicianService.listTechnician();
    }

    @GetMapping("/{id}")
    public TechnicianResponseDTO getTechnicianById(@PathVariable UUID id){
        return technicianService.getTechnicianById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<TechnicianResponseDTO>> updateTechnician (@Valid @PathVariable UUID id,
                                                                 @RequestBody TechnicianRequestDTO dto) {
        TechnicianResponseDTO user = technicianService.updateTechnician(id,dto);
        return ResponseEntity.ok(
                new Response<>(
                        true,
                        "Tecnico actualizado correctamente",
                        user
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteTechnician(@PathVariable UUID id){
        technicianService.deleteTechnician(id);

        return ResponseEntity.ok(
                new Response<>(
                        true,
                        "Tecnico eliminado correctamente",
                        null
                ));
    }
}
