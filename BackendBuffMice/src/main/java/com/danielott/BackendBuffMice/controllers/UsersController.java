package com.danielott.BackendBuffMice.controllers;

import com.danielott.BackendBuffMice.domain.token.dto.TokenReponseDTO;
import com.danielott.BackendBuffMice.domain.user.Users;
import com.danielott.BackendBuffMice.domain.user.dto.UsersDetailsDTO;
import com.danielott.BackendBuffMice.domain.user.dto.UsersRegisterDTO;
import com.danielott.BackendBuffMice.services.UsersService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/register")
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping
    @Transactional
    public ResponseEntity save (@RequestBody @Valid UsersRegisterDTO data, UriComponentsBuilder uriBuilder) {
        var user = new Users(data);
        String token = service.save(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        List<Record> response = List.of(new UsersDetailsDTO(user), new TokenReponseDTO(token));

        return ResponseEntity.created(uri).body(response);
    }
}
