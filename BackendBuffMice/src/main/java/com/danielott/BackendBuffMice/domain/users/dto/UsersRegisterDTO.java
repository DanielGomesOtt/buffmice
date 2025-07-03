package com.danielott.BackendBuffMice.domain.users.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsersRegisterDTO(

        String name,

        String email,

        String password
) {
}
