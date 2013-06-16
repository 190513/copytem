package br.com.copytem.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.copytem.dao.CaixaDAO;
import br.com.copytem.model.Caixa;

@Resource
public class CaixaController {

	private final Result result;
	private final CaixaDAO caixaDAO;

	public CaixaController(Result r, CaixaDAO c) {
		this.result = r;
		this.caixaDAO = c;
	}

	@Post("/caixa/adiciona")
	public void adicionar(Caixa caixa) {
		caixaDAO.adiciona(caixa);
		result.redirectTo(this).listall();

	}

	public void deletar(int id) {
		Caixa c = caixaDAO.load(id);
		caixaDAO.delete(c);
		result.redirectTo(this).listall();
	}

	public List<Caixa> listall() {
		return caixaDAO.loadCaixas();
	}

	public void edita(Caixa caixa) {
		caixaDAO.atualiza(caixa);
		result.redirectTo(this).listall();
	}
	
	@Path("/caixa/editar")
	public Caixa editar(int id) {
		return caixaDAO.load(id);
	}

	@Path("/caixa/form")
	public void form() {

	}

}
