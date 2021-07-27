package br.com.zupacademy.thiago.casadocodigo.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.thiago.casadocodigo.controller.form.NovoAutorForm;
import br.com.zupacademy.thiago.casadocodigo.domain.Autor;
import br.com.zupacademy.thiago.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> cria(@RequestBody @Valid NovoAutorForm form) {
		Autor autor = form.toModel();
		repository.save(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();

		return ResponseEntity.created(uri).body(new AutorDto(autor));
	}
}
