package br.com.zupacademy.thiago.casadocodigo.controller.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {NumericValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Numeric {

	String message() default "Deve conter apenas números";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
