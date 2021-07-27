package br.com.zupacademy.thiago.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.thiago.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.thiago.casadocodigo.domain.Categoria;

public class NovaCategoriaForm {

	@NotBlank
	@UniqueValue(entityClass = Categoria.class, fieldName = "nome", message="Categoria já existente no banco de dados")
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public Categoria toModel() {
		return new Categoria(this.nome);
	}
}
