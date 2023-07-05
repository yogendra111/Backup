package ksolves.demospringmvc.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordValidator.class)
@Documented
@Target(ElementType.FIELD) //class level variables
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatePassword {
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
	String message() default "Password is incorrect";
}
