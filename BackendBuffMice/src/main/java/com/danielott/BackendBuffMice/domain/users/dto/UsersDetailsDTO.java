package com.danielott.BackendBuffMice.domain.users.dto;

import com.danielott.BackendBuffMice.domain.users.Users;

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
