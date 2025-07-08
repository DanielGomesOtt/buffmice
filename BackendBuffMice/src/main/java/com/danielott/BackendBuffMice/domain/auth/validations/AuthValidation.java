package com.danielott.BackendBuffMice.domain.auth.validations;

import com.danielott.BackendBuffMice.domain.users.dto.UserLoginDTO;

public interface AuthValidation {

    void validate(UserLoginDTO data);
}
