package br.com.zupacademy.thiago.casadocodigo.controller.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.thiago.casadocodigo.controller.validation.ExistsId;
import br.com.zupacademy.thiago.casadocodigo.domain.Estado;
import br.com.zupacademy.thiago.casadocodigo.domain.Pais;

public class NovoEstadoForm {

	@NotBlank
	private String nome;
	
	@NotNull
	@ExistsId(entityClass = Pais.class, fieldName = "id", message="País não existente no banco de dados")
	private Long paisId;

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}
	
	public Estado toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, this.getPaisId());
		
		return new Estado(this.nome, pais);
	}
}
