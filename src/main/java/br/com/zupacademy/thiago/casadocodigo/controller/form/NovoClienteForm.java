package br.com.zupacademy.thiago.casadocodigo.controller.form;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.thiago.casadocodigo.controller.validation.BrDoc;
import br.com.zupacademy.thiago.casadocodigo.controller.validation.CEP;
import br.com.zupacademy.thiago.casadocodigo.controller.validation.ExistsId;
import br.com.zupacademy.thiago.casadocodigo.controller.validation.Numeric;
import br.com.zupacademy.thiago.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.thiago.casadocodigo.domain.Cliente;
import br.com.zupacademy.thiago.casadocodigo.domain.Estado;
import br.com.zupacademy.thiago.casadocodigo.domain.Pais;
import br.com.zupacademy.thiago.casadocodigo.exception.DataIntegrityViolationException;
import br.com.zupacademy.thiago.casadocodigo.repository.EstadoRepository;

public class NovoClienteForm {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@UniqueValue(entityClass = Cliente.class, fieldName = "documento", message = "Documento já existente no banco de dados")
	@NotBlank
	@BrDoc(message = "Documento deve ser um CPF ou CNPJ válido")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ExistsId(entityClass = Pais.class, fieldName = "id", message = "ID do pais não existente no banco de dados")
	private Long paisId;

	private Long estadoId;

	@NotBlank
	@Numeric
	private String telefone;

	@NotBlank
	@CEP
	private String cep;

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

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Cliente toModel(EntityManager manager, EstadoRepository estadoRepository) {
		Pais pais = manager.find(Pais.class, this.paisId);

		Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
				this.complemento, this.cidade, pais, this.telefone, this.cep);

		if (this.estadoId != null) {
			System.out.println("passou por aqui 1");
			Optional<Estado> estado = estadoRepository.findById(estadoId);
			if (estado.isPresent()) {
				if(cliente.getPais().getEstados().contains(estado.get())) {
					cliente.setEstado(estado.get());
				} else {
					throw new DataIntegrityViolationException("Estado não corresponde ao país");
				}
			}
		} else if(cliente.getPais().getEstados().size() > 0) {
			throw new DataIntegrityViolationException("Estado não pode ser nulo para esse país");
		}
		return cliente;
	}
}
