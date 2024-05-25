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

import br.com.aula.teste.entities.Habilidade;
import br.com.aula.teste.services.HabilidadeService;

@RestController
@RequestMapping("/habilidades")
public class HabilidadeController {

	@Autowired
	HabilidadeService habilidadeService;

	@GetMapping("/listar")
	public List<Habilidade> listarHabilidades() {
		return habilidadeService.listarHabilidades();
	}
	
	@GetMapping("/buscar/{habilidadeId}")
	public ResponseEntity<Habilidade> buscarHabilidade(@PathVariable int habilidadeId) {
        Habilidade habilidade = habilidadeService.buscarHabilidade(habilidadeId);
        return new ResponseEntity<>(habilidade, HttpStatus.OK);
    }
	
	@PostMapping("/salvar")
	public ResponseEntity<Habilidade> salvar(@RequestBody Habilidade habilidade) {
		Habilidade novaHabilidade = habilidadeService.salvarHabilidade(habilidade);
		if (novaHabilidade != null) {
			return new ResponseEntity<>(novaHabilidade, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(novaHabilidade, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/atualizar/{habilidadeId}")
	public ResponseEntity<String> atualizarHabilidade(@PathVariable int habilidadeId, @RequestBody Habilidade novaHabilidade) {
		boolean habilidadeAtualizada = habilidadeService.atualizarHabilidade(habilidadeId, novaHabilidade);
		if (habilidadeAtualizada) {
			return ResponseEntity.status(HttpStatus.OK).body("Habilidade atualizada com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao atualizar a Habilidade!");
		}
	}
	
	@DeleteMapping("/deletar/{habilidadeId}")
	public ResponseEntity<String> deletarHabilidade(@PathVariable int habilidadeId) {
		boolean habilidadeDeletada = habilidadeService.deletarHabilidade(habilidadeId);
		if (habilidadeDeletada) {
			return ResponseEntity.status(HttpStatus.OK).body("Habilidade deletada com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao deletar a Habilidade!");
		}
	}
	
}
