package com.gamehub.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    private static final String PASSWORD_PATTERN =
        "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=[\\\\]{}|;':\",.<>/?]).{8,12}$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.isBlank()) {
            // Leave blank checks to @NotEmpty
            return true;
        }

        return password.matches(PASSWORD_PATTERN);
    }
}
