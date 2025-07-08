package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.repositories.UsersRepository;
import com.danielott.BackendBuffMice.domain.users.validations.UsersValidation;
import com.danielott.BackendBuffMice.infra.security.SecurityConfiguration;
import com.danielott.BackendBuffMice.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private SecurityConfiguration security;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private List<UsersValidation> validations;


    public String save (Users user) {
        validations.forEach(validation -> validation.validate(user));
        PasswordEncoder passwordEncoder = security.passwordEncoder();
        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        user.setStatus(1);
        repository.save(user);
        return tokenService.signToken(user);
    }
}
