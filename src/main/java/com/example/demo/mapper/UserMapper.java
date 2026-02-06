package com.example.demo.mapper;

import com.example.demo.dto.userDto.UserRequestDTO;
import com.example.demo.dto.userDto.UserResponseDTO;
import com.example.demo.models.User;

public class UserMapper {
    public static User toEntity(UserRequestDTO dto){
        User user = new User();
        user.setNombre(dto.getNombre());
        user.setEmail(dto.getEmail());
        user.setEdad(dto.getEdad());
        return user;
    }

    public static UserResponseDTO toDTO(User user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setNombre(user.getNombre());
        dto.setEmail(user.getEmail());
        dto.setEdad(user.getEdad());
        return dto;
    }

}
