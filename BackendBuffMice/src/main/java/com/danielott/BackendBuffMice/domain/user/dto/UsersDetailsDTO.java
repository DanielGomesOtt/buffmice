package com.danielott.BackendBuffMice.domain.user.dto;

import com.danielott.BackendBuffMice.domain.user.Users;

public record UsersDetailsDTO (

        Long id,
        String name,
        String email,
        Integer status
) {

    public UsersDetailsDTO(Users user){
        this(user.getId(), user.getName(), user.getEmail(), user.getStatus());
    }
}
