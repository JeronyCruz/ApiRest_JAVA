package com.example.demo.services;

import com.example.demo.dto.usuarioDto.UserRequestDTO;
import com.example.demo.dto.usuarioDto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO insertUser(UserRequestDTO dto);
    List<UserResponseDTO> listUser();
}
