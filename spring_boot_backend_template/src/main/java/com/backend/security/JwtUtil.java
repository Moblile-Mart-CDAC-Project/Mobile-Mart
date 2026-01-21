package com.backend.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    // ===============================
    // GENERATE TOKEN (EMAIL + ROLE)
    // ===============================
    public String generateToken(String email, String role) {

        return Jwts.builder()
                .setSubject(email)              // email
                .claim("role", role)            // role
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + expiration)
                )
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ===============================
    // EXTRACT EMAIL
    // ===============================
    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    // ===============================
    // EXTRACT ROLE
    // ===============================
    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // ===============================
    // COMMON CLAIMS PARSER
    // ===============================
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    // ===============================
    //  Validate Token
    // ===============================
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
