package br.com.batista.listaEstudantes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.batista.listaEstudantes.model.Estudante;
import br.com.batista.listaEstudantes.repository.EstudanteRepository;

@Service
public class EstudanteService {
	
	@Autowired
	private EstudanteRepository repository;
	
	public void salvar(Estudante estudante) {
		repository.save(estudante);
	}
	
	public Iterable<Estudante> obterTodos() {
		Iterable<Estudante> estudantes = repository.findAll();
		return estudantes;
	}
	
}
