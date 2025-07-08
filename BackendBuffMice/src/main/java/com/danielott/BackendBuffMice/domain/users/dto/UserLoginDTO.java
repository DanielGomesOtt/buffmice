package com.danielott.BackendBuffMice.domain.users.dto;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDTO(

        String email,

        String password
) {
}
