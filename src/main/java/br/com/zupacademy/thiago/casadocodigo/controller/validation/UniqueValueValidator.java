package br.com.zupacademy.thiago.casadocodigo.controller.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object>{
	
	@PersistenceContext
	private EntityManager manager;
	
	private String fieldName;
	private Class<?> entityClass;
	
	@Override
	public void initialize(UniqueValue params) {
		fieldName = params.fieldName();
		entityClass = params.entityClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("SELECT 1 FROM " + entityClass.getSimpleName() + " WHERE " + fieldName + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <=1, "");		
		
		return list.isEmpty();
	}
	
	

}
