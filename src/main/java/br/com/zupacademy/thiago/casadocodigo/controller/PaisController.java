package br.com.zupacademy.thiago.casadocodigo.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.PaisDto;
import br.com.zupacademy.thiago.casadocodigo.controller.form.NovoPaisForm;
import br.com.zupacademy.thiago.casadocodigo.domain.Pais;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<PaisDto> cria(@RequestBody @Valid NovoPaisForm form) {
		Pais pais = form.toModel();
		manager.persist(pais);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pais.getId()).toUri();

		return ResponseEntity.created(uri).body(new PaisDto(pais));
	}
}
