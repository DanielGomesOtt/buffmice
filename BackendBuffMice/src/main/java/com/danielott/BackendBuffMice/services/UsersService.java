package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.user.Users;
import com.danielott.BackendBuffMice.domain.user.repositories.UsersRepository;
import com.danielott.BackendBuffMice.infra.security.SecurityConfiguration;
import com.danielott.BackendBuffMice.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private SecurityConfiguration security;

    @Autowired
    private TokenService tokenService;

    public String save (Users user) {
        var passwordEncoder = security.passwordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(1);
        try {
            repository.save(user);
            return tokenService.signToken(user);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
