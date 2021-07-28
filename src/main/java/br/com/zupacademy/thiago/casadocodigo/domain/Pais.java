package br.com.zupacademy.thiago.casadocodigo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	@NotBlank
	private String nome;
	
	@OneToMany(mappedBy="pais")
	private List<Estado> estados = new ArrayList<>();

	public Pais() {
	}
	
	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(getId(), other.getId());
	}

}
