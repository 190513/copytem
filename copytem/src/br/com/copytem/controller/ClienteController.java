package br.com.copytem.controller;

import java.util.List;


import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.copytem.dao.ClienteDAO;
import br.com.copytem.model.Cliente;

@Resource
public class ClienteController {

	private final Result result;
	private final ClienteDAO clienteDAO;

	public ClienteController(Result r, ClienteDAO c) {
		this.result = r;
		this.clienteDAO = c;
	}

	@Post("/cliente/adiciona")
	public void adicionar(Cliente cliente) {
		clienteDAO.adiciona(cliente);
		result.redirectTo(this).listall();

	}

	public void deletar(int id) {
		Cliente c = clienteDAO.load(id);
		clienteDAO.delete(c);
		result.redirectTo(this).listall();
	}

	public List<Cliente> listall() {
		return clienteDAO.loadClientes();
	}

	public void edita(Cliente cliente) {
		clienteDAO.atualiza(cliente);
		result.redirectTo(this).listall();
	}
	
	@Path("/cliente/editar")
	public Cliente editar(int id) {
		return clienteDAO.load(id);
	}

	@Path("/cliente/form")
	public void form() {

	}
	
	public List<Cliente> busca (String nome){
		result.include("nome", nome);
		return clienteDAO.busca(nome);
	}
	
	@Get
	@Path("/cliente/busca.json")
	public void buscaJson(String name_startsWith){
		System.out.println(name_startsWith);
		 result.use(Results.json()).withoutRoot()
	      .from(clienteDAO.busca(name_startsWith))
	    .serialize();
	}

}
