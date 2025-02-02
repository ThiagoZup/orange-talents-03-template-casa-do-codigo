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

import br.com.zupacademy.thiago.casadocodigo.controller.dto.CategoriaDto;
import br.com.zupacademy.thiago.casadocodigo.controller.form.NovaCategoriaForm;
import br.com.zupacademy.thiago.casadocodigo.domain.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDto> cria(@RequestBody @Valid NovaCategoriaForm form) {
		Categoria categoria = form.toModel();
		manager.persist(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();

		return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
	}
}
