package br.com.aula.teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.teste.dto.AlunoDTO;
import br.com.aula.teste.entities.Aluno;
import br.com.aula.teste.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping("/listar")
	public List<AlunoDTO> listarAlunos() {
		return alunoService.listarAlunos();
	}
	
	@GetMapping("/buscar/{alunoId}")
	public ResponseEntity<AlunoDTO> buscarAluno(@PathVariable int alunoId) {
		AlunoDTO aluno = alunoService.buscarAluno(alunoId);
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }
	
	@PostMapping("/salvar")
	public ResponseEntity<AlunoDTO> salvarAluno(@RequestBody AlunoDTO aluno) {
		AlunoDTO novoAluno = alunoService.salvarAluno(aluno);
		if (novoAluno != null) {
			return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(novoAluno, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/atualizar/{alunoId}")
	public ResponseEntity<String> atualizarHabilidade(@PathVariable int alunoId, @RequestBody Aluno novoAluno) {
		boolean alunoAtualizado = alunoService.atualizarAluno(alunoId, novoAluno);
		if (alunoAtualizado) {
			return ResponseEntity.status(HttpStatus.OK).body("Aluno atualizado com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao atualizar o Aluno!");
		}
	}
	
	@DeleteMapping("/deletar/{alunoId}")
	public ResponseEntity<String> deletarAluno(@PathVariable int alunoId) {
		boolean alunoDeletado = alunoService.deletarAluno(alunoId);
		if (alunoDeletado) {
			return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao deletar o Aluno!");
		}
	}
	
}
