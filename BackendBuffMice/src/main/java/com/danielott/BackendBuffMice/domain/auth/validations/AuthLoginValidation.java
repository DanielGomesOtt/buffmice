package com.danielott.BackendBuffMice.domain.auth.validations;

import com.danielott.BackendBuffMice.domain.users.dto.UserLoginDTO;
import com.danielott.BackendBuffMice.exceptions.AuthLoginValidationException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class AuthLoginValidation implements AuthValidation{

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );

    @Override
    public void validate(UserLoginDTO data) {
        if(!EMAIL_PATTERN.matcher(data.email()).matches()) {
            throw new AuthLoginValidationException("The email cannot be empty and must respect the valid email pattern.");
        }

        if(data.password() == null || data.password().isEmpty()) {
            throw new AuthLoginValidationException("The password must be provided.");
        }
    }
}
