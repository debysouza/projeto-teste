package br.com.aula.teste.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno_habilidade")
public class AlunoHabilidade {

	@EmbeddedId
    private AlunoHabilidadeEmbeddable chaveComposta;

    @Column(name = "nivel")
    private Integer nivel;

	public AlunoHabilidade() {
	}

	public AlunoHabilidade(AlunoHabilidadeEmbeddable chaveComposta, Integer nivel) {
		this.chaveComposta = chaveComposta;
		this.nivel = nivel;
	}

	public AlunoHabilidadeEmbeddable getChaveComposta() {
		return chaveComposta;
	}

	public void setChaveComposta(AlunoHabilidadeEmbeddable chaveComposta) {
		this.chaveComposta = chaveComposta;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
    
}
