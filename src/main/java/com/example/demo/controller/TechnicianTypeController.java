package com.example.demo.controller;

import com.example.demo.dto.common.Response;
import com.example.demo.dto.technicianDto.TechnicianRequestDTO;
import com.example.demo.dto.technicianDto.TechnicianResponseDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeRequestDTO;
import com.example.demo.dto.technicianTypeDto.TechnicianTypeResponseDTO;
import com.example.demo.dto.userDto.UserRequestDTO;
import com.example.demo.dto.userDto.UserResponseDTO;
import com.example.demo.services.TechnicianService;
import com.example.demo.services.TechnicianTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/technicianType")
public class TechnicianTypeController {
    @Autowired
    private TechnicianTypeService technicianTypeService;

    public TechnicianTypeController(TechnicianTypeService technicianTypeService){
        this.technicianTypeService = technicianTypeService;
    }

    @PostMapping
    public ResponseEntity<Response<TechnicianTypeResponseDTO>> postUser(@Valid @RequestBody TechnicianTypeRequestDTO dto){

        TechnicianTypeResponseDTO technicianType = technicianTypeService.insertTechnicianType(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>(
                true,
                "Tipo Tecnico creado correctamente",
                technicianType
        ));

    }

    @GetMapping
    public List<TechnicianTypeResponseDTO> getTechnicianType(){
        return technicianTypeService.listTechnicianType();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<TechnicianTypeResponseDTO>> updateTechnicianType (@Valid @PathVariable UUID id,
                                                                             @RequestBody TechnicianTypeRequestDTO dto) {
        TechnicianTypeResponseDTO user = technicianTypeService.updateTechnicianType(id,dto);
        return ResponseEntity.ok(
                new Response<>(
                        true,
                        "Tipo Tecnico actualizado correctamente",
                        user
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteTechnician(@PathVariable UUID id){
        technicianTypeService.deleteTechnicianType(id);

        return ResponseEntity.ok(
                new Response<>(
                        true,
                        "Tipo Tecnico eliminado correctamente",
                        null
                ));
    }
}
