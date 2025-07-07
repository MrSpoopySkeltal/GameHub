package com.gamehub.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.gamehub.app.models.RegisterModel;

public class PasswordMatchValidator implements ConstraintValidator<ValidPasswordMatch, RegisterModel> {

	@Override
	public boolean isValid(RegisterModel user, ConstraintValidatorContext context) {
	    String p1 = user.getPassword();
	    String p2 = user.getConfirmPassword();

	    // Let @NotEmpty handle nulls/blanks
	    if (p1 == null || p2 == null || p1.isBlank() || p2.isBlank()) {
	        return true;
	    }

	    System.out.println("[DEBUG] PasswordMatchValidator is evaluating: " + p1 + " vs " + p2);

	    return p1.equals(p2);
	}

}
