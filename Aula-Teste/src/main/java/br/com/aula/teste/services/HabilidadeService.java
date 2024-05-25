package br.com.aula.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aula.teste.entities.Habilidade;
import br.com.aula.teste.exception.AlunoHabilidadeNotFoundException;
import br.com.aula.teste.repositories.HabilidadeRepository;

@Service
public class HabilidadeService {

	@Autowired
	HabilidadeRepository habilidadeRepository;
	
	public List<Habilidade> listarHabilidades() {
		return habilidadeRepository.findAll();
	}
	
    public Habilidade buscarHabilidade(int habilidadeId) {
        return habilidadeRepository.findById(habilidadeId)
                .orElseThrow(() -> new AlunoHabilidadeNotFoundException("Habilidade com ID = " + habilidadeId + " não foi encontrada na base de dados."));
    }
	
	public Habilidade salvarHabilidade(Habilidade habilidade) {
		return habilidadeRepository.save(habilidade);
	}

	public boolean atualizarHabilidade(int habilidadeId, Habilidade novaHabilidade) {
		Habilidade antigaHabilidade = buscarHabilidade(habilidadeId);
		if(antigaHabilidade != null) {
			antigaHabilidade.setId(habilidadeId);
			if(novaHabilidade.getNome() != null) {
				antigaHabilidade.setNome(novaHabilidade.getNome());
			}
			if(novaHabilidade.getDescricao() != null) {
				antigaHabilidade.setDescricao(novaHabilidade.getDescricao());
			}
			habilidadeRepository.save(antigaHabilidade);
			return true;
		}
		return false;
	}
	
	public boolean deletarHabilidade(int habilidadeId) {
		Optional<Habilidade> habilidade = habilidadeRepository.findById(habilidadeId);
		if(habilidade.isPresent()) {
			habilidadeRepository.deleteById(habilidadeId);
			return true;
		}
		return false;
	}
	
}
