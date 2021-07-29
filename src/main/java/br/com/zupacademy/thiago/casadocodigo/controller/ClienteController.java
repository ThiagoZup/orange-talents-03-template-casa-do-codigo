package br.com.zupacademy.thiago.casadocodigo.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.NovoClienteDto;
import br.com.zupacademy.thiago.casadocodigo.controller.form.NovoClienteForm;
import br.com.zupacademy.thiago.casadocodigo.domain.Cliente;
import br.com.zupacademy.thiago.casadocodigo.repository.EstadoRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cria(@RequestBody @Valid NovoClienteForm form) {
		Cliente cliente = form.toModel(manager, estadoRepository);
		manager.persist(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();

		return ResponseEntity.created(uri).body(new NovoClienteDto(cliente));
	}
}
