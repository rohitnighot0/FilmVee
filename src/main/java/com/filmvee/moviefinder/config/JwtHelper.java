package com.filmvee.moviefinder.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtHelper {
    @Autowired
    private UserDetailsService userDetailsService;
    private final long validity = 500000;
    private final String secret = "EWCBKEWCWEQCEWCWIDN29EU12E192EHDN32DB12W9H129H1D3B0DS12SJEICBIWF323D2290HNC2XNOQ9DN2DCBEQCECNE9";
    byte[] encododeKey = Base64.getEncoder().encode(secret.getBytes(StandardCharsets.UTF_8));
    private final Key keys = Keys.hmacShaKeyFor(encododeKey);

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(keys, SignatureAlgorithm.HS256)
                .compact();
    }
    public Claims getAllClaims(String jwt) {
        return Jwts.parserBuilder().setSigningKey(keys).build().parseClaimsJws(jwt).getBody();
    }
    public String getUsernameFromToken(String jwt) {
        return getAllClaims(jwt).getSubject();
    }
    public boolean validateToken(String jwt, UserDetails userDetails) {
        return getUsernameFromToken(jwt).equals(userDetails.getUsername()) &&
                getAllClaims(jwt).getExpiration().after(new Date(System.currentTimeMillis()));
    }
}
