package com.inside.interview.controller.config;

import com.inside.interview.entity.dto.JwtRequest;
import com.inside.interview.service.AccountDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAuthenticationManager {
    private JwtTokenUtil jwtTokenUtil;
    private AccountDetailsService accountDetailsService;
    private AuthenticationManager authenticationManager;

    public String authenticate(JwtRequest jwtRequest) throws AuthenticationException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        jwtRequest.getName(),
                        jwtRequest.getPassword()));
        return getToken(jwtRequest.getName());
    }

    private String getToken(String username) {
        UserDetails userDetails = accountDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }

}