package com.example.demo.services;

import com.example.demo.dto.userDto.UserRequestDTO;
import com.example.demo.dto.userDto.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDTO insertUser(UserRequestDTO dto);
    List<UserResponseDTO> listUser();
    UserResponseDTO getUserById(int id);
    UserResponseDTO updateUser(int id, UserRequestDTO dto);
    void deleteUser(int id);
}
