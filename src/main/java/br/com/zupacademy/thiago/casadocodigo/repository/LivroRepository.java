package br.com.zupacademy.thiago.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.thiago.casadocodigo.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
