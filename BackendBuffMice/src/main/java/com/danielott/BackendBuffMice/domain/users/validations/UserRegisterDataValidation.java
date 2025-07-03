package com.danielott.BackendBuffMice.domain.users.validations;

import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.exceptions.UserRegisterValidationException;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterDataValidation implements UsersValidation{
    @Override
    public void validate(Users user) {
        if(user.getName() == null || user.getName().isEmpty()) {
            throw new UserRegisterValidationException("The username cannot be empty.");
        }

        if(user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new UserRegisterValidationException("The email cannot be empty.");
        }

        if(user.getPassword() == null || user.getPassword().isEmpty() ||  user.getPassword().length() < 8) {
            throw new UserRegisterValidationException("The password must be at least 8 characters long.");
        }
    }


}
