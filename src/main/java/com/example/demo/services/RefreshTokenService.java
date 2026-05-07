package com.example.demo.services;

import com.example.demo.models.RefreshToken;
import com.example.demo.models.User;
import com.example.demo.repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository repo;

    @Value("${jwt.refresh.expiration}")
    private Long refreshExpiration;

    public RefreshTokenService(RefreshTokenRepository repo) {
        this.repo = repo;
    }

    public RefreshToken create(User user) {

        Optional<RefreshToken> existing = repo.findByUser(user);

        RefreshToken token = existing.orElse(new RefreshToken());

        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Instant.now().plusMillis(refreshExpiration));

        return repo.save(token);
    }

    public RefreshToken validate(String token) {

        RefreshToken refreshToken = repo.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Refresh token no encontrado"));

        if (refreshToken.getExpiryDate().isBefore(Instant.now())) {
            repo.delete(refreshToken);
            throw new RuntimeException("Refresh token expirado");
        }

        return refreshToken;
    }
}
