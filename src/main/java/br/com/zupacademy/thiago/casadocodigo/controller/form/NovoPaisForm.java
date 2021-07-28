package br.com.zupacademy.thiago.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.thiago.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.thiago.casadocodigo.domain.Pais;

public class NovoPaisForm {

	@NotBlank
	@UniqueValue(entityClass = Pais.class, fieldName = "nome", message="País já existente no banco de dados")
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public Pais toModel() {
		return new Pais(this.nome);
	}
}
