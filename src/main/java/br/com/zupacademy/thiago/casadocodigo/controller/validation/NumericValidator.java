package br.com.zupacademy.thiago.casadocodigo.controller.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumericValidator implements ConstraintValidator<Numeric, Object>{
	
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		return String.valueOf(value).matches("-?\\d+(\\.\\d+)?");
	}
	
	

}
