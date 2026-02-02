package com.project.back_end.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TokenService {
    private final String SECRET = "Webfinanzas_AI_2026";

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date()) // Requerido
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora; Requerido
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}