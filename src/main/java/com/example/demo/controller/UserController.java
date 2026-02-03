package com.example.demo.controller;

import com.example.demo.dto.usuarioDto.UserRequestDTO;
import com.example.demo.dto.usuarioDto.UserResponseDTO;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO postUser(@RequestBody UserRequestDTO dto){
        return userService.insertUser(dto);
    }

    @GetMapping
    public List<UserResponseDTO> getUsers(){
        return userService.listUser();
    }
}
