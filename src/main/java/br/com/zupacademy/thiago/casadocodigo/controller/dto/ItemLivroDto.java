package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.thiago.casadocodigo.domain.Livro;

public class ItemLivroDto {

	private Long id;
	private String titulo;
	
	public ItemLivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<ItemLivroDto> toModel(List<Livro> livros) {
		return livros.stream().map(ItemLivroDto::new).collect(Collectors.toList());
	}
}
