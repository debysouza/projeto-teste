package br.com.aula.teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.teste.dto.AlunoHabilidadeDTO;
import br.com.aula.teste.dto.ListaAlunosHabilidadesDTO;
import br.com.aula.teste.services.AlunoHabilidadeService;

@RestController
@RequestMapping("/alunos-habilidades")
public class AlunoHabilidadeController {

	@Autowired
	AlunoHabilidadeService alunoHabilidadeService;

	@PostMapping("/associarAlunoHabilidade")
	public ResponseEntity<String> associarAlunoHabilidade(@RequestBody AlunoHabilidadeDTO alunoHabilidade) {
		alunoHabilidadeService.associarAlunoHabilidade(alunoHabilidade);
		return ResponseEntity.status(HttpStatus.OK).body("Aluno ID = " + alunoHabilidade.getAlunoId() + " foi associado a Habilidade ID = " + alunoHabilidade.getHabilidadeId() + " com sucesso!");
	}

	@GetMapping("/listar")
	public List<ListaAlunosHabilidadesDTO> listarAlunosHabilidades() {
		return alunoHabilidadeService.listarAlunosHabilidades();
	}
	
	@DeleteMapping("/deletar/{alunoId}/{habilidadeId}")
	public ResponseEntity<String> deletarHabilidade(@PathVariable int alunoId, @PathVariable int habilidadeId) {
		boolean alunoHabilidadeDeletada = alunoHabilidadeService.deletarAlunoHabilidade(alunoId, habilidadeId);
		if (alunoHabilidadeDeletada) {
			return ResponseEntity.status(HttpStatus.OK).body("Habilidade deletada com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao deletar a Habilidade!");
		}
	}
	
}
