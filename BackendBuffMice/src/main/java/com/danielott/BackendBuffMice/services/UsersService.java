package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.repositories.UsersRepository;
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
        try {
            var passwordEncoder = security.passwordEncoder();
            String passwordEncoded = passwordEncoder.encode(user.getPassword());
            user.setPassword(passwordEncoded);
            user.setStatus(1);
            repository.save(user);
            return tokenService.signToken(user);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
