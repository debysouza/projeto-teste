package br.com.aula.teste.exception;

public class AlunoHabilidadeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlunoHabilidadeNotFoundException(String message) {
        super(message);
    }
    
}