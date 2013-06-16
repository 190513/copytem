package br.com.copytem.controller;


import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.copytem.dao.ContasReceberDAO;
import br.com.copytem.model.ContasReceber;

@Resource
public class ContasReceberController {
	
	private final Result result;
	private final ContasReceberDAO contasReceberDAO;
	
	public ContasReceberController(Result r, ContasReceberDAO cs) {
		this.result = r;
		this.contasReceberDAO = cs;
	}
	
	@Post("/contasReceber/adiciona")
	public void adicionar(ContasReceber contasReceber){
		contasReceberDAO.adiciona(contasReceber);
		result.redirectTo(this).form();
		
	}
	
	public void deletar(ContasReceber contasReceber){
		contasReceberDAO.delete(contasReceber);
		result.redirectTo(this).form();
	}
	
	    public List<ContasReceber> listall() {
	        return contasReceberDAO.loadContasRecebers();
	    }

	
	@Path("/contasReceber/form")
	public void form(){
		
	}
	

	
	
}
