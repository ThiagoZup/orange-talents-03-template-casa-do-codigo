package br.com.zupacademy.thiago.casadocodigo.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.thiago.casadocodigo.controller.validation.BrDoc;
import br.com.zupacademy.thiago.casadocodigo.controller.validation.CEP;
import br.com.zupacademy.thiago.casadocodigo.controller.validation.Numeric;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Email
	@Column(unique=true)
	private String email;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@Column(unique=true)
	@NotBlank
	@BrDoc
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@ManyToOne
	@NotNull
	private Pais pais;
	
	@ManyToOne
	private Estado estado;
	
	@NotBlank
	@Numeric
	private String telefone;
	
	@NotBlank
	@CEP
	private String cep;

	public Cliente() {
	}
	
	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Pais pais, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}	
}
