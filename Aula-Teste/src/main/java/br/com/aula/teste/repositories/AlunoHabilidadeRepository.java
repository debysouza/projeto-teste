package br.com.aula.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.aula.teste.entities.AlunoHabilidade;
import br.com.aula.teste.entities.AlunoHabilidadeEmbeddable;

@Repository
public interface AlunoHabilidadeRepository extends JpaRepository<AlunoHabilidade, AlunoHabilidadeEmbeddable> {

	@Query(value="select * from aluno_habilidade ah where ah.aluno_id = :alunoId and ah.habilidade_id = :habilidadeId", nativeQuery=true)
	AlunoHabilidade buscarAlunoHabilidade(int alunoId, int habilidadeId);
	
}
