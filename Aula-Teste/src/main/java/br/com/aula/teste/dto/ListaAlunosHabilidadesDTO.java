package br.com.aula.teste.dto;

import br.com.aula.teste.entities.AlunoHabilidade;

public class ListaAlunosHabilidadesDTO {

	private AlunoDTO alunoDTO;
	private HabilidadeDTO habilidade;

	public ListaAlunosHabilidadesDTO(AlunoHabilidade alunoHabilidade) {
		this.alunoDTO = new AlunoDTO(alunoHabilidade.getChaveComposta().getAluno());
		this.habilidade = new HabilidadeDTO(alunoHabilidade);
	}
	
	public AlunoDTO getAlunoDTO() {
		return alunoDTO;
	}

	public void setAlunoDTO(AlunoDTO alunoDTO) {
		this.alunoDTO = alunoDTO;
	}

	public HabilidadeDTO getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(HabilidadeDTO habilidade) {
		this.habilidade = habilidade;
	}

}
