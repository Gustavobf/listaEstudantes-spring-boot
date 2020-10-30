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

	public void deletar(Long id) {
		repository.deleteById(id);
	}

//	public void atualizar(Estudante estudante) {
//		Optional<Estudante> estudanteAntigo = repository.findById(estudante.getId());
//		repository.save(estudante);
//	}

	public Estudante obterPeloId(Long id) {
		Iterable<Estudante> lista = repository.findAll();

		for (Estudante estudante : lista) {
			if (estudante.getId() == id) {
				return estudante;
			}
		}
		return null;

	}

	public Iterable<Estudante> obterTodos() {
		Iterable<Estudante> estudantes = repository.findAll();
		return estudantes;
	}

}
