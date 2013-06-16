package br.com.copytem.controller;


import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.copytem.dao.PagamentoDAO;
import br.com.copytem.model.Pagamento;

@Resource
public class PagamentoController {
	
	private final Result result;
	private final PagamentoDAO pagamentoDAO;
	
	public PagamentoController(Result r, PagamentoDAO p) {
		this.result = r;
		this.pagamentoDAO = p;
	}
	
	@Post("/pagamento/adiciona")
	public void adicionar(Pagamento pagamento){
		pagamentoDAO.adiciona(pagamento);
		result.redirectTo(this).form();
		
	}
	
	public void deletar(Pagamento pagamento){
		pagamentoDAO.delete(pagamento);
		result.redirectTo(this).form();
	}
	
	    public List<Pagamento> listall() {
	        return pagamentoDAO.loadPagamentos();
	    }

	
	@Path("/pagamento/form")
	public void form(){
		
	}
	

	
	
}
