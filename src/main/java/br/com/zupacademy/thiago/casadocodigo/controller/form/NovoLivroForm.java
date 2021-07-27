package br.com.zupacademy.thiago.casadocodigo.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.thiago.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.thiago.casadocodigo.domain.Autor;
import br.com.zupacademy.thiago.casadocodigo.domain.Categoria;
import br.com.zupacademy.thiago.casadocodigo.domain.Livro;

public class NovoLivroForm {
	
	@NotBlank
	@UniqueValue(entityClass = Livro.class, fieldName = "titulo", message="Título já existente no banco de dados")
	private String titulo;
	
	@NotBlank
	@Length(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull
	@Min(20)
	private BigDecimal preco;
	
	@NotNull
	@Min(100)
	private Integer numeroPaginas;
	
	@NotBlank
	@UniqueValue(entityClass = Livro.class, fieldName = "isbn", message="ISBN já existente no banco de dados")
	private String isbn;
	
	@Future
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataPublicacao;
	
	@NotNull
	private Long categoriaId;
	
	@NotNull
	private Long autorId;

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

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}
	
	public Livro toModel(EntityManager manager) {
		Autor autor = manager.find(Autor.class, this.getAutorId());
		Categoria categoria = manager.find(Categoria.class, this.getCategoriaId());

		Livro livro = new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn, this.dataPublicacao, categoria, autor);
		return livro;
	}
}
