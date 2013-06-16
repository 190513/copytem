package br.com.copytem.controller;


import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.copytem.dao.OrdemServicoDAO;
import br.com.copytem.model.OrdemServico;

@Resource
public class OrdemServicoController {
	
	private final Result result;
	private final OrdemServicoDAO ordemServicoDAO;
	
	public OrdemServicoController(Result r, OrdemServicoDAO os) {
		this.result = r;
		this.ordemServicoDAO = os;
	}
	
	@Post("/ordemServico/adiciona")
	public void adicionar(OrdemServico ordemServico){
		System.out.println("aqui");
		ordemServicoDAO.adiciona(ordemServico);
		result.redirectTo(this).form();
		
	}
	
	public void deletar(OrdemServico ordemServico){
		ordemServicoDAO.delete(ordemServico);
		result.redirectTo(this).form();
	}
	
	    public List<OrdemServico> listall() {
	        return ordemServicoDAO.loadOrdemServicos();
	    }

	
	@Path("/ordemServico/form")
	public void form(){
		
	}
	

	
	
}
