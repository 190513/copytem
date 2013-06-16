package br.com.copytem.controller;


import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.copytem.dao.ItemOrdemServicoDAO;
import br.com.copytem.model.ItemOrdemServico;

@Resource
public class ItemOrdemServicoController {
	
	private final Result result;
	private final ItemOrdemServicoDAO itemOrdemServicoDAO;
	
	public ItemOrdemServicoController(Result r, ItemOrdemServicoDAO i) {
		this.result = r;
		this.itemOrdemServicoDAO = i;
	}
	
	@Post("/itemOrdemServico/adiciona")
	public void adicionar(ItemOrdemServico itemOrdemServico){
		itemOrdemServicoDAO.adiciona(itemOrdemServico);
		result.redirectTo(this).form();
		
	}
	
	public void deletar(ItemOrdemServico itemOrdemServico){
		itemOrdemServicoDAO.delete(itemOrdemServico);
		result.redirectTo(this).form();
	}
	
	    public List<ItemOrdemServico> listall() {
	        return itemOrdemServicoDAO.loadItemOrdemServicos();
	    }

	
	@Path("/itemOrdemServico/form")
	public void form(){
		
	}
	

	
	
}
