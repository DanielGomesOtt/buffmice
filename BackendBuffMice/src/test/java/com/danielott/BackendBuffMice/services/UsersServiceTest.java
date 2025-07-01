package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.repositories.UsersRepository;
import com.danielott.BackendBuffMice.infra.security.SecurityConfiguration;
import com.danielott.BackendBuffMice.infra.security.TokenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @Mock
    private UsersRepository repository;

    @Mock
    private SecurityConfiguration security;

    @Mock
    private TokenService tokenService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsersService service;

    @Test
    @DisplayName("Should return a token when user is saved successfully")
    void shouldReturnTokenWhenUserIsSavedSuccessfully() {
        // Arrange
        Users user = new Users();
        user.setPassword("plainPassword");

        String encodedPassword = "encodedPassword";
        String expectedToken = "mockedToken";

        when(security.passwordEncoder()).thenReturn(passwordEncoder);
        when(passwordEncoder.encode("plainPassword")).thenReturn(encodedPassword);
        when(tokenService.signToken(user)).thenReturn(expectedToken);

        // Act
        String token = service.save(user);

        // Assert
        assertEquals(expectedToken, token);
        assertEquals(encodedPassword, user.getPassword());
        assertEquals(1, user.getStatus());

        verify(repository).save(user);
        verify(tokenService).signToken(user);
    }

    @Test
    @DisplayName("Should throw exception when passwordEncoder.encode fails")
    void shouldThrowExceptionWhenPasswordEncodingFails() {
        Users user = new Users();
        user.setPassword("123456");
        when(security.passwordEncoder()).thenReturn(passwordEncoder);
        when(passwordEncoder.encode(user.getPassword())).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> service.save(user));

        verify(passwordEncoder).encode(user.getPassword());
        verify(repository, never()).save(any());
        verify(tokenService, never()).signToken(any());

    }

    @Test
    @DisplayName("Should throw exception when repository.save fails")
    void shouldThrowExceptionWhenRepositorySaveFails() {
        Users user = new Users();
        user.setPassword("1234545");
        user.setName("user");
        user.setEmail("user@email.com");
        user.setStatus(1);
        when(security.passwordEncoder()).thenReturn(passwordEncoder);
        when(passwordEncoder.encode(anyString())).thenReturn("senha codificada");
        when(repository.save(user)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> service.save(user));

        verify(repository).save(user);
        verify(tokenService, never()).signToken(any());
    }

    @Test
    @DisplayName("Should throw exception when tokenService.signToken fails")
    void shouldThrowExceptionWhenTokenGenerationFails() {
        Users user = new Users();
        user.setPassword("1234545");
        user.setName("user");
        user.setEmail("user@email.com");
        user.setStatus(1);
        when(security.passwordEncoder()).thenReturn(passwordEncoder);
        when(passwordEncoder.encode(anyString())).thenReturn("senha codificada");
        when(repository.save(user)).thenReturn(user);
        when(tokenService.signToken(user)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> service.save(user));

        verify(tokenService).signToken(user);
    }
}