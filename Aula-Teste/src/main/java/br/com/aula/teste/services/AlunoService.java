package br.com.aula.teste.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aula.teste.dto.AlunoDTO;
import br.com.aula.teste.entities.Aluno;
import br.com.aula.teste.exception.AlunoHabilidadeNotFoundException;
import br.com.aula.teste.repositories.AlunoHabilidadeRepository;
import br.com.aula.teste.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	AlunoHabilidadeRepository alunoHabilidadeRepository;
	
	public List<AlunoDTO> listarAlunos() {
		List<Aluno> alunos = alunoRepository.findAll();
		List<AlunoDTO> alunosDTO = new ArrayList<>();
		for(Aluno aluno : alunos) {
			AlunoDTO alunoDTO = new AlunoDTO(aluno);
	        alunosDTO.add(alunoDTO);
		}
		return alunosDTO;
	}
	
    public AlunoDTO buscarAluno(int alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new AlunoHabilidadeNotFoundException("Aluno com ID = " + alunoId + " não foi encontrado na base de dados."));
        return new AlunoDTO(aluno);
    }
	
	public AlunoDTO salvarAluno(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno(alunoDTO);
		alunoRepository.save(aluno);
		return alunoDTO;
	}
	
	public boolean atualizarAluno(int alunoId, Aluno novoAluno) {
		Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
	    if (alunoOptional.isPresent()) {
	    	Aluno antigoAluno = alunoOptional.get();
			antigoAluno.setId(alunoId);
			if(novoAluno.getNome() != null) {
				antigoAluno.setNome(novoAluno.getNome());
			}
			if(novoAluno.getMatricula() != null) {
				antigoAluno.setMatricula(novoAluno.getMatricula());
			}
			if(novoAluno.getEmail() != null) {
				antigoAluno.setEmail(novoAluno.getEmail());
			}
			if(novoAluno.getDataNascimento() != null) {
				antigoAluno.setDataNascimento(novoAluno.getDataNascimento());
			}
			if(novoAluno.getStatus() != null) {
				antigoAluno.setStatus(novoAluno.getStatus());
			}
			alunoRepository.save(antigoAluno);
			return true;
		}
		return false;
	}
	
	public boolean deletarAluno(int alunoId) {
	    Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
	    if (alunoOptional.isPresent()) {
	        Aluno aluno = alunoOptional.get();
	        aluno.setStatus(false);
	        alunoRepository.save(aluno);
	        return true;
	    }
	    return false;
	}

}
