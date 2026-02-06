package com.example.demo.services.impl;

import com.example.demo.dto.userDto.UserRequestDTO;
import com.example.demo.dto.userDto.UserResponseDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository usuarioRepository;

    public UserServiceImpl(UserRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserResponseDTO insertUser(UserRequestDTO dto) {
        User usuario = UserMapper.toEntity(dto);
        User usuarioGuardado = usuarioRepository.save(usuario);
        return UserMapper.toDTO((usuarioGuardado));
    }

    @Override
    public List<UserResponseDTO> listUser(){
        return usuarioRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(int id) {
        User user = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado con id: " + id)
                );

        return UserMapper.toDTO(user);
    }

    @Override
    public UserResponseDTO updateUser(int id, UserRequestDTO dto) {
        User user = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado con id: " + id)
                );

        // actualizar campos
        user.setNombre(dto.getNombre());
        user.setEmail(dto.getEmail());
        user.setEdad(dto.getEdad());

        User updatedUser = usuarioRepository.save(user);
        return UserMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }

}

