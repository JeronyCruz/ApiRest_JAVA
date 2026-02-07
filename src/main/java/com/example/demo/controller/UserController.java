package com.example.demo.controller;

import com.example.demo.dto.common.Response;
import com.example.demo.dto.userDto.UserRequestDTO;
import com.example.demo.dto.userDto.UserResponseDTO;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Response<UserResponseDTO>> postUser(@Valid @RequestBody UserRequestDTO dto){

        UserResponseDTO user = userService.insertUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>(
                    true,
                "Usuario creado correctamente",
                         user
                ));

    }

    @GetMapping
    public List<UserResponseDTO> getUsers(){
        return userService.listUser();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<UserResponseDTO>> updateUser (@Valid @PathVariable int id,
                                       @RequestBody UserRequestDTO dto) {
        UserResponseDTO user =userService.updateUser(id,dto);
        return ResponseEntity.ok(
                new Response<>(
                        true,
                        "Usuario actualizado correctamente",
                        user
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteUser(@PathVariable int id){
        userService.deleteUser(id);

        return ResponseEntity.ok(
                new Response<>(
                        true,
                        "Usuario eliminado correctamente",
                        null
                ));
    }
}
