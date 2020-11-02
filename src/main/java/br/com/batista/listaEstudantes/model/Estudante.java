package br.com.batista.listaEstudantes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String matricula;

	public Estudante() {
	}

	public Estudante(String nome, String email, String matricula) {
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
	}
	
	public Estudante(Long id, String nome, String email, String matricula) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Estudante [id=" + id + ", nome=" + nome + ", email=" + email + ", matricula=" + matricula + "]";
	}

}
