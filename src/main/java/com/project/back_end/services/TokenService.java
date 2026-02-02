package com.project.back_end.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import java.security.Key;

@Service
public class TokenService {
    private String secret = "esta_es_una_clave_secreta_muy_larga_para_jwt_256_bits";

    public String generate(String email) {
        return Jwts.builder().setSubject(email).compact();
    }

    public Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}