package br.com.copytem.controller;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.copytem.dao.ProdutoDAO;
import br.com.copytem.model.Carrinho;
import br.com.copytem.model.Item;

@Resource
public class CarrinhoController {

	private final Carrinho carrinho;	
	private final ProdutoDAO dao;
	private final HttpServletRequest request;
	private final Result result;

	public CarrinhoController(Carrinho carrinho, ProdutoDAO dao, Result result,HttpServletRequest request) {
		this.carrinho = carrinho;
		this.dao = dao;
		this.result = result;
		this.request = request;
	}

	@Post
	@Path("/carrinho")
	public void adiciona(Item item) {
		dao.recarrega(item.getProduto());
		carrinho.adiciona(item);
		result.redirectTo(OrdemServicoController.class).form();
	}

	@Delete("/carrinho/{indiceItem}")
	public void remove(int indiceItem) {
		carrinho.remove(indiceItem);
		result.redirectTo(OrdemServicoController.class).form();
	}
	
	public void salva(HttpServletRequest request){
		
		
	}
	


}
