package com.danielott.BackendBuffMice.controllers;

import com.danielott.BackendBuffMice.domain.auth.dto.AuthResponseDTO;
import com.danielott.BackendBuffMice.domain.auth.validations.AuthValidation;
import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.dto.UserLoginDTO;
import com.danielott.BackendBuffMice.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private List<AuthValidation> validations;

    @PostMapping
    public ResponseEntity<AuthResponseDTO> login (@RequestBody UserLoginDTO data) {
        validations.forEach(validation -> validation.validate(data));
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        Authentication authentication = authenticationManager.authenticate(token);
        String authenticationToken = tokenService.signToken((Users) authentication.getPrincipal());
        return ResponseEntity.ok(new AuthResponseDTO(authenticationToken));
    }
}
