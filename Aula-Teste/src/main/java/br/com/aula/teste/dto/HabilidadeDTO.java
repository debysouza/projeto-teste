package br.com.aula.teste.dto;

import br.com.aula.teste.entities.AlunoHabilidade;

public class HabilidadeDTO {

	private String nome;
	private String descricao;
	private int nivel;

	public HabilidadeDTO(AlunoHabilidade alunoHabilidade) {
		this.nome = alunoHabilidade.getChaveComposta().getHabilidade().getNome();
		this.descricao = alunoHabilidade.getChaveComposta().getHabilidade().getDescricao();
		this.nivel = alunoHabilidade.getNivel();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
