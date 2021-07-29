package br.com.zupacademy.thiago.casadocodigo.controller;

import java.net.URI;
import java.util.List;

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

import br.com.zupacademy.thiago.casadocodigo.controller.dto.NovoEstadoDto;
import br.com.zupacademy.thiago.casadocodigo.controller.form.NovoEstadoForm;
import br.com.zupacademy.thiago.casadocodigo.domain.Estado;
import br.com.zupacademy.thiago.casadocodigo.exception.FieldMessage;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cria(@RequestBody @Valid NovoEstadoForm form) {
		Estado estado = form.toModel(manager);
		
		List<Estado> estadoRepetido = manager.createQuery("SELECT x FROM Estado x WHERE x.nome = :nome AND x.pais = :pais", Estado.class).setParameter("nome", estado.getNome()).setParameter("pais", estado.getPais()).getResultList();
		if(estadoRepetido.size() > 0) {
			return ResponseEntity.badRequest().body(new FieldMessage("nome", "Estado já existente para esse país"));
		}
		manager.persist(estado);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estado.getId()).toUri();

		return ResponseEntity.created(uri).body(new NovoEstadoDto(estado));
	}
}
