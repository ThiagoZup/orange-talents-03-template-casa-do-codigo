package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.domain.Estado;

public class NovoEstadoDto {

	private Long id;
	private String nome;
	private String pais;
	
	public NovoEstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.pais = estado.getPais().getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getPais() {
		return pais;
	}
	
}
