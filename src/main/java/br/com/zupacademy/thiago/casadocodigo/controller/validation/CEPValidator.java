package br.com.zupacademy.thiago.casadocodigo.controller.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.thiago.casadocodigo.controller.validation.utils.BR;

public class CEPValidator implements ConstraintValidator<CEP, Object>{
	
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(BR.isValidCep(String.valueOf(value))) {
			return true;
		}	
		return false;
	}
	
	

}
