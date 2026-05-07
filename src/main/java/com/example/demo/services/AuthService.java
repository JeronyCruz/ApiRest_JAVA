package com.example.demo.services;

import com.example.demo.dto.auth.AuthResponse;
import com.example.demo.dto.auth.LoginRequest;
import com.example.demo.dto.auth.RegisterRequest;
import com.example.demo.dto.userDto.UserRequestDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.RefreshToken;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;

    public AuthService(
            UserRepository userRepo,
            JwtService jwtService,
            RefreshTokenService refreshTokenService,
            PasswordEncoder encoder,
            AuthenticationManager authManager
    ) {
        this.userRepo = userRepo;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
        this.encoder = encoder;
        this.authManager = authManager;
    }

    public AuthResponse register(RegisterRequest dto) {

        User user = new User();
        user.setNombre(dto.getNombre());
        user.setEmail(dto.getEmail());
        user.setEdad(dto.getEdad());
        user.setPassword(encoder.encode(dto.getPassword()));

        userRepo.save(user);

        String access = jwtService.generateAccessToken(user.getEmail());
        String refresh = refreshTokenService.create(user).getToken();

        return new AuthResponse(access, refresh);
    }

    public AuthResponse login(LoginRequest dto) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );

        User user = userRepo.findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuario no existe")
                );

        String access = jwtService.generateAccessToken(user.getEmail());
        String refresh = refreshTokenService.create(user).getToken();

        return new AuthResponse(access, refresh);
    }

    public AuthResponse refresh(String refreshToken) {
        RefreshToken token = refreshTokenService.validate(refreshToken);
        User user = token.getUser();
        String newAccessToken = jwtService.generateAccessToken(user.getEmail());
        return new AuthResponse(newAccessToken, token.getToken());
    }

}


