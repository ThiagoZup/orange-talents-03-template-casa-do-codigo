package br.com.zupacademy.thiago.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.thiago.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.thiago.casadocodigo.domain.Autor;

public class AutorForm {

	@NotEmpty
	private String nome;
	
	@NotEmpty
	@Email
	@UniqueValue(entityClass = Autor.class, fieldName = "email", message="Email já existente no banco de dados")
	private String email;
	
	@NotEmpty
	@Length(max = 400)
	private String descricao;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Autor converter() {
		return new Autor(this.nome, this.email, this.descricao);
	}
}
