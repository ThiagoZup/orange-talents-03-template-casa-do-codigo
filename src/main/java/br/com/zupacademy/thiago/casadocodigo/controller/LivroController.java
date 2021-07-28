package br.com.zupacademy.thiago.casadocodigo.controller;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.ItemLivroDto;
import br.com.zupacademy.thiago.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.thiago.casadocodigo.controller.form.NovoLivroForm;
import br.com.zupacademy.thiago.casadocodigo.domain.Livro;
import br.com.zupacademy.thiago.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private LivroRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroDto> cria(@RequestBody @Valid NovoLivroForm form) {
		Livro livro = form.toModel(manager);
		
		repository.save(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();

		return ResponseEntity.created(uri).body(new LivroDto(livro));
	}
	
	@GetMapping
	public ResponseEntity<List<ItemLivroDto>> lista(){
		List<Livro>  livros = repository.findAll();	
		
		return ResponseEntity.ok().body(ItemLivroDto.toModel(livros));
	}
}
