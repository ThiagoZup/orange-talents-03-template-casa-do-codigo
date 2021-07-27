package br.com.zupacademy.thiago.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.thiago.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.thiago.casadocodigo.domain.Autor;

public class NovoAutorForm {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@UniqueValue(entityClass = Autor.class, fieldName = "email", message="Email já existente no banco de dados")
	private String email;
	
	@NotBlank
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
	
	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
}
