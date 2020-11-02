package br.com.batista.listaEstudantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.batista.listaEstudantes.model.Estudante;
import br.com.batista.listaEstudantes.service.EstudanteService;

@Controller
public class ApplicationController {

	@Autowired
	private EstudanteService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("lista")
	public String listaEstudantes(Model model) {

		Iterable<Estudante> estudantes = service.obterTodos();

		model.addAttribute("estudantes", estudantes);

		return "listaEstudantes";
	}

	@RequestMapping("/convidar")
	public String formConvidar() {
		return "formConvidar";
	}

	@RequestMapping("/formAtualizar")
	public String formAtualizar(@RequestParam("id") Long id, Model model) {

		Estudante estudante = service.obterPeloId(id);

		model.addAttribute("estudante", estudante);

		return "formAtualizar";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("matricula") String matricula, Model model) {

		Estudante novoEstudante = new Estudante(nome, email, matricula);

		service.salvar(novoEstudante);

		Iterable<Estudante> estudantes = service.obterTodos();

		model.addAttribute("estudantes", estudantes);

		return "listaEstudantes";

	}

	@RequestMapping("/atualizar")
	public String atualizar(@RequestParam("id") Long id, @RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("matricula") String matricula, Model model) {
		
		Estudante estudante = new Estudante(id, nome, email, matricula);
		service.atualizar(estudante);

		Iterable<Estudante> estudantes = service.obterTodos();

		model.addAttribute("estudantes", estudantes);
		
		return "listaEstudantes";

	}

	@RequestMapping("/deletar")
	public String deletar(@RequestParam("id") Long id, Model model) {

		service.deletar(id);

		Iterable<Estudante> estudantes = service.obterTodos();

		model.addAttribute("estudantes", estudantes);

		return "listaEstudantes";
	}

}
