package br.com.batista.listaEstudantes.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.batista.listaEstudantes.model.Estudante;

public interface EstudanteRepository extends CrudRepository<Estudante, Long> {

}
