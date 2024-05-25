package br.com.aula.teste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aula.teste.dto.AlunoHabilidadeDTO;
import br.com.aula.teste.dto.ListaAlunosHabilidadesDTO;
import br.com.aula.teste.entities.Aluno;
import br.com.aula.teste.entities.AlunoHabilidade;
import br.com.aula.teste.entities.AlunoHabilidadeEmbeddable;
import br.com.aula.teste.entities.Habilidade;
import br.com.aula.teste.repositories.AlunoHabilidadeRepository;
import br.com.aula.teste.repositories.AlunoRepository;

@Service
public class AlunoHabilidadeService {
	
	@Autowired
	HabilidadeService habilidadeService;
	
	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	AlunoHabilidadeRepository alunoHabilidadeRepository;

	public AlunoHabilidade associarAlunoHabilidade(AlunoHabilidadeDTO alunoHabilidadeDTO) {
		Aluno aluno = alunoRepository.findById(alunoHabilidadeDTO.getAlunoId()).get();
		Habilidade habilidade = habilidadeService.buscarHabilidade(alunoHabilidadeDTO.getHabilidadeId());
		AlunoHabilidadeEmbeddable chaveComposta = new AlunoHabilidadeEmbeddable(aluno, habilidade);
		
		AlunoHabilidade alunoHabilidade = new AlunoHabilidade();
		alunoHabilidade.setChaveComposta(chaveComposta);
		alunoHabilidade.setNivel(alunoHabilidadeDTO.getNivel());
		return alunoHabilidadeRepository.save(alunoHabilidade);
	}
	
	public List<ListaAlunosHabilidadesDTO> listarAlunosHabilidades() {
		List<AlunoHabilidade> alunosHabilidades = alunoHabilidadeRepository.findAll();
		List<ListaAlunosHabilidadesDTO> alunosHabilidadesDTO = new ArrayList<>();
		for(AlunoHabilidade alunoHabilidade : alunosHabilidades) {
			ListaAlunosHabilidadesDTO alunoHabilidadesDTO = new ListaAlunosHabilidadesDTO(alunoHabilidade);
	        alunosHabilidadesDTO.add(alunoHabilidadesDTO);
		}
		return alunosHabilidadesDTO;
	}
	
	public boolean deletarAlunoHabilidade(int alunoId, int habilidadeId) {
		AlunoHabilidade alunoHabilidade = alunoHabilidadeRepository.buscarAlunoHabilidade(alunoId, habilidadeId);
		if(alunoHabilidade != null) {
			alunoHabilidadeRepository.delete(alunoHabilidade);
			return true;
		}
		return false;
	}
	
}
