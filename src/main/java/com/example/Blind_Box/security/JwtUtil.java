package com.example.Blind_Box.security;

import com.example.Blind_Box.entity.SystemAccounts;
import com.example.Blind_Box.repository.AccountRepository;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    private final long EXPIRATION_TIME = 864_000_000; // 10 days

    private final AccountRepository accountRepository;

    public JwtUtil(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String generateToken(String email) {
        SystemAccounts account = accountRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        if (account == null || account.getRole() == null) {
            throw new IllegalArgumentException("Account or role not found");
        }
        String roleString = convertRoleToString(account.getRole());
        return Jwts.builder()
                .setSubject(email)
                .claim("role", roleString)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    private String convertRoleToString(Integer role) {
        switch (role) {
            case 1:
                return "ROLE_ADMIN";
            case 2:
                return "ROLE_MODERATOR";
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String getRoleFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}