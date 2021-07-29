package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.domain.Cliente;

public class NovoClienteDto {

	private Long id;
	private String email;
	private String nome;
	private String sobrenome;
	private String documento;
	private String endereco;
	private String complemento;
	private String cidade;
	private String pais;
	private String estado;
	private String telefone;
	private String cep;
	
	public NovoClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.email = cliente.getEmail();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.documento = cliente.getDocumento();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.pais = cliente.getPais().getNome();
		this.estado = cliente.getEstado().getNome();
		this.telefone = cliente.getTelefone();
		this.cep = cliente.getCep();
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

	public String getPais() {
		return pais;
	}

	public String getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	
}
