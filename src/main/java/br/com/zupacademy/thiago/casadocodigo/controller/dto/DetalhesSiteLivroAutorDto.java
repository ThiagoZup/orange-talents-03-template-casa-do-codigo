package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.domain.Autor;

public class DetalhesSiteLivroAutorDto {
	
	private String nome;
	private String descricao;
	
	public DetalhesSiteLivroAutorDto(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}


	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
