package br.com.copytem.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.copytem.dao.FuncionarioDAO;
import br.com.copytem.model.Funcionario;

@Resource
public class FuncionarioController {

	private final Result result;
	private final FuncionarioDAO funcionarioDAO;

	public FuncionarioController(Result r, FuncionarioDAO p) {
		this.result = r;
		this.funcionarioDAO = p;
	}

	@Post("/funcionario/adiciona")
	public void adicionar(Funcionario funcionario) {
		funcionarioDAO.adiciona(funcionario);
		result.redirectTo(this).listall();

	}
	
	public void deletar(int id) {
		Funcionario p = funcionarioDAO.load(id);
		funcionarioDAO.delete(p);
		result.redirectTo(this).listall();
	}

	public List<Funcionario> listall() {
		return funcionarioDAO.loadFuncionarios();
	}

	public void edita(Funcionario funcionario) {
		funcionarioDAO.atualiza(funcionario);
		result.redirectTo(this).listall();
	}
	
	@Path("/funcionario/editar")
	public Funcionario editar(int id) {
		return funcionarioDAO.load(id);
	}

	@Path("/funcionario/form")
	public void form() {

	}

}
