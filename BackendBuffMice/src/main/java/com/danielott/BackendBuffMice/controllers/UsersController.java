package com.danielott.BackendBuffMice.controllers;

import com.danielott.BackendBuffMice.domain.token.dto.TokenReponseDTO;
import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.dto.UsersDetailsDTO;
import com.danielott.BackendBuffMice.domain.users.dto.UsersRegisterDTO;
import com.danielott.BackendBuffMice.services.UsersService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> save (@RequestBody UsersRegisterDTO data, UriComponentsBuilder uriBuilder) {
        var user = new Users(data);
        String token = service.save(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        List<Record> response = List.of(new UsersDetailsDTO(user), new TokenReponseDTO(token));

        return ResponseEntity.created(uri).body(response);
    }
}
