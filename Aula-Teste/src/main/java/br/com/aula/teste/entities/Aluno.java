package br.com.aula.teste.entities;

import java.time.LocalDate;
import java.util.Set;

import br.com.aula.teste.dto.AlunoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "matricula")
    private Long matricula;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "data_nascimento")
    private LocalDate dataNascimento;
	
	@Column(name = "status")
    private Boolean status;
	
	@ManyToMany
    @JoinTable(
            name = "aluno_habilidade",
            joinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "habilidade_id", referencedColumnName = "id")
    )
    private Set<Habilidade> habilidades;

	public Aluno() {
	}

	public Aluno(int id, String nome, Long matricula, String email, LocalDate dataNascimento,
			Boolean status, Set<Habilidade> habilidades) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.status = true;
		this.habilidades = habilidades;
	}
	
	public Aluno(AlunoDTO alunoDTO) {
		this.id = alunoDTO.getId();
        this.nome = alunoDTO.getNome();
        this.matricula = alunoDTO.getMatricula();
        this.email = alunoDTO.getEmail();
        this.dataNascimento = alunoDTO.getDataNascimento();
        this.status = alunoDTO.getStatus();
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

	public Set<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Set<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	
}
