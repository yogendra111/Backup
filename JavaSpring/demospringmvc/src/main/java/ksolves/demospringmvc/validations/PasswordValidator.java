package ksolves.demospringmvc.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidatePassword, String> {

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value != null && !value.isBlank() && value.length() == 8) {
			return true;
		}
		return false;
	}
}
