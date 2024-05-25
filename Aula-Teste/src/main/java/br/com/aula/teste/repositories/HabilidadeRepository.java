package br.com.aula.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aula.teste.entities.Habilidade;

@Repository
public interface HabilidadeRepository extends JpaRepository<Habilidade, Integer> {

}
