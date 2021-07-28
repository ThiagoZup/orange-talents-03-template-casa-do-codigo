package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import java.math.BigDecimal;

import br.com.zupacademy.thiago.casadocodigo.domain.Livro;

public class DetalhesSiteLivroDto {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPaginas;
	private String isbn;
	private DetalhesSiteLivroAutorDto autor;

	public DetalhesSiteLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.autor = new DetalhesSiteLivroAutorDto(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public DetalhesSiteLivroAutorDto getAutor() {
		return autor;
	}
	
}

