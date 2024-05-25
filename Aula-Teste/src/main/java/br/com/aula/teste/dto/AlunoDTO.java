package br.com.aula.teste.dto;

import java.time.LocalDate;

import br.com.aula.teste.entities.Aluno;

public class AlunoDTO {

	private int id;
	private String nome;
	private Long matricula;
	private String email;
	private LocalDate dataNascimento;
	private Boolean status;

	public AlunoDTO(Aluno aluno) {
		this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.matricula = aluno.getMatricula();
        this.email = aluno.getEmail();
        this.dataNascimento = aluno.getDataNascimento();
        this.status = aluno.getStatus();
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
