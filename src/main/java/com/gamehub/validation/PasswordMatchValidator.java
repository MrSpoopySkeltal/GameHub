package com.gamehub.validation;

import com.gamehub.dto.UserDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PasswordMatchValidator implements ConstraintValidator<ValidPasswordMatch, UserDTO> {

    @Override
    public boolean isValid(UserDTO user, ConstraintValidatorContext context) {
        String p1 = user.getPassword();
        String p2 = user.getConfirmPassword();

        // Let @NotEmpty handle nulls/blanks
        if (p1 == null || p2 == null || p1.isBlank() || p2.isBlank()) {
            return true;
        }

        return p1.equals(p2);
    }
}
