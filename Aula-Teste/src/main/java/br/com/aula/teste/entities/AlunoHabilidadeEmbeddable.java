package br.com.aula.teste.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AlunoHabilidadeEmbeddable {

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "habilidade_id")
    private Habilidade habilidade;

	public AlunoHabilidadeEmbeddable() {
	}

	public AlunoHabilidadeEmbeddable(Aluno aluno, Habilidade habilidade) {
		this.aluno = aluno;
		this.habilidade = habilidade;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, habilidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoHabilidadeEmbeddable other = (AlunoHabilidadeEmbeddable) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(habilidade, other.habilidade);
	}
    
}
