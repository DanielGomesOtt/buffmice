package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.repositories.UsersRepository;
import com.danielott.BackendBuffMice.domain.users.validations.UsersValidation;
import com.danielott.BackendBuffMice.infra.security.SecurityConfiguration;
import com.danielott.BackendBuffMice.infra.security.TokenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @Mock
    private UsersRepository repository;

    @Mock
    private SecurityConfiguration security;

    @Mock
    private TokenService tokenService;

    @Mock
    private List<UsersValidation> validations;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsersService service;

    @Test
    @DisplayName("The user should be successfully created and the token should be returned.")
    void UserSuccessfullyCreated() {
        Users user = new Users("user", "user@email.com", "1234");
        user.setStatus(1);
        when(security.passwordEncoder()).thenReturn(passwordEncoder);
        when(passwordEncoder.encode("1234")).thenReturn("encodedPassword");
        when(repository.save(user)).thenReturn(user);
        when(tokenService.signToken(user)).thenReturn("fake-jwt-token");

        String token = service.save(user);


        verify(security).passwordEncoder();
        verify(passwordEncoder).encode(user.getPassword());
        verify(repository).save(user);
        verify(tokenService).signToken(user);

        assertNotNull(token);
        assertEquals("fake-jwt-token", token);

    }
}