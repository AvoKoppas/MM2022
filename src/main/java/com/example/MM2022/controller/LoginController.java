package com.example.MM2022.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {
    @CrossOrigin
    @PostMapping("/public/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Date tokenExpirationDate = new Date(new Date().getTime() + 1000 * 60 * 60 * 24);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setExpiration(tokenExpirationDate)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "password")
                .claim("username", LoginRequest.getUsername());
        return jwtBuilder.compact();

    }

}
