package com.inside.interview.controller;

import com.inside.interview.controller.config.UserAuthenticationManager;
import com.inside.interview.entity.dto.JwtRequest;
import com.inside.interview.entity.dto.JwtResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;

@RestController
@AllArgsConstructor
public class AccountController {
    private UserAuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<?> getAuthentication(@RequestBody JwtRequest jwtRequest) {
        String token;
        try {
            token = authenticationManager.authenticate(jwtRequest);
        } catch (NoResultException e) {
            throw new UsernameNotFoundException("No user found");
        }
        return ResponseEntity.ok(new JwtResponse(token));
    }

}