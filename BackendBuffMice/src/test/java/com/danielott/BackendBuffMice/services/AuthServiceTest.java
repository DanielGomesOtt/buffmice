package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.repositories.UsersRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private AuthService authService;

    @Test
    @DisplayName("Should load user details by email")
    void shouldLoadUserDetailsWhenEmailExists() {
        Users user = new Users(1L, "user", "user@email.com", "12345", 1);
        when(usersRepository.findByEmail("user@email.com")).thenReturn(user);

        UserDetails userDetails = authService.loadUserByUsername("user@email.com");

        assertEquals("user@email.com", userDetails.getUsername());
        assertEquals("12345", userDetails.getPassword());
    }

    @Test
    @DisplayName("Should throw UsernameNotFoundException when user is not found")
    void shouldThrowUsernameNotFoundExceptionWhenEmailDoesNotExist() {
        when(usersRepository.findByEmail("user@email.com"))
                .thenThrow(new UsernameNotFoundException("User not found"));

        Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
            authService.loadUserByUsername("user@email.com");
        });

        assertEquals("User not found", exception.getMessage());
    }

}