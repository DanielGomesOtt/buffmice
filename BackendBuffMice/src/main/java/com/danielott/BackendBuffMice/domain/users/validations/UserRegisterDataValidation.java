package com.danielott.BackendBuffMice.domain.users.validations;

import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.exceptions.UserRegisterValidationException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserRegisterDataValidation implements UsersValidation{

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );

    @Override
    public void validate(Users user) {
        if(user.getName() == null || user.getName().isEmpty()) {
            throw new UserRegisterValidationException("The username cannot be empty.");
        }

        if(!EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
            throw new UserRegisterValidationException("The email cannot be empty and must respect the valid email pattern.");
        }

        if(user.getPassword() == null || user.getPassword().isEmpty() ||  user.getPassword().length() < 8) {
            throw new UserRegisterValidationException("The password must be at least 8 characters long.");
        }
    }


}
