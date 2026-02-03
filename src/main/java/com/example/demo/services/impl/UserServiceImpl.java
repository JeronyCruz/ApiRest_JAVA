package com.example.demo.services.impl;

import com.example.demo.dto.usuarioDto.UserRequestDTO;
import com.example.demo.dto.usuarioDto.UserResponseDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}

