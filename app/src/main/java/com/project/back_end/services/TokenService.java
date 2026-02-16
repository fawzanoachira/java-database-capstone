package com.project.back_end.services;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.project.back_end.models.Admin;
import com.project.back_end.models.Doctor;
import com.project.back_end.models.Patient;
import com.project.back_end.repo.AdminRepository;
import com.project.back_end.repo.DoctorRepository;
import com.project.back_end.repo.PatientRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    private final AdminRepository adminRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    
    public TokenService(AdminRepository adminRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.adminRepository = adminRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    // Return type changed to SecretKey to fix verifyWith(...) issue
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    // Generate token with email only
    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7))
                .signWith(getSigningKey())
                .compact();
    }

    // Generate token with additional claims (userType and username/email)
    public String generateToken(Object userId, String userType, String email) {
        return Jwts.builder()
                .subject(email)
                .claim("userId", userId)
                .claim("userType", userType)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7))
                .signWith(getSigningKey())
                .compact();
    }

    // Extract email from token
    public String extractEmail(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // Extract email from token (alias method for consistency)
    public String extractEmailFromToken(String token) {
        return extractEmail(token);
    }

    // Extract doctor ID from token
    public Long extractDoctorIdFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            
            // Extract userId claim and convert to Long
            Object userIdObj = claims.get("userId");
            
            if (userIdObj instanceof Integer) {
                return ((Integer) userIdObj).longValue();
            } else if (userIdObj instanceof Long) {
                return (Long) userIdObj;
            } else if (userIdObj instanceof String) {
                return Long.parseLong((String) userIdObj);
            }
            
            // If userId claim doesn't exist, try to get doctor by email
            String email = claims.getSubject();
            Doctor doctor = doctorRepository.findByEmail(email);
            return doctor != null ? doctor.getId() : null;
            
        } catch (Exception e) {
            return null;
        }
    }

    // Extract user type from token
    public String extractUserType(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            
            return claims.get("userType", String.class);
        } catch (Exception e) {
            return null;
        }
    }

    // Extract user ID from token (generic method)
    public Long extractUserId(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            
            Object userIdObj = claims.get("userId");
            
            if (userIdObj instanceof Integer) {
                return ((Integer) userIdObj).longValue();
            } else if (userIdObj instanceof Long) {
                return (Long) userIdObj;
            } else if (userIdObj instanceof String) {
                return Long.parseLong((String) userIdObj);
            }
            
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    // Validate token based on user type
    public boolean validateToken(String token, String user) {
        try {
            String extracted = extractEmail(token);
            
            if (user.equals("admin")) {
                Admin admin = adminRepository.findByUsername(extracted);
                return admin != null;
            } else if (user.equals("doctor")) {
                Doctor doctor = doctorRepository.findByEmail(extracted);
                return doctor != null;
            } else if (user.equals("patient")) {
                Patient patient = patientRepository.findByEmail(extracted);
                return patient != null;
            }

            return false;
        } catch (Exception e) {
            return false;
        }
    }

    // Check if token is expired
    public boolean isTokenExpired(String token) {
        try {
            Date expiration = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getExpiration();
            
            return expiration.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }
}