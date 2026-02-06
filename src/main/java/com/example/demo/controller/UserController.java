package com.example.demo.controller;

import com.example.demo.dto.userDto.UserRequestDTO;
import com.example.demo.dto.userDto.UserResponseDTO;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserResponseDTO postUser(@RequestBody UserRequestDTO dto){
        return userService.insertUser(dto);
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
    public UserResponseDTO updateUser (@PathVariable int id,
                                       @RequestBody UserRequestDTO dto) {
        return userService.updateUser(id,dto);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
