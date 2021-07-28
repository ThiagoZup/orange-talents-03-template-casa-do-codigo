package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.domain.Pais;

public class PaisDto {

	private Long id;
	private String nome;
	
	public PaisDto(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
