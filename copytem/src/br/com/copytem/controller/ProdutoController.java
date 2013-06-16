package br.com.copytem.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jquery.datatables.controller.DataTablesParamUtility;
import jquery.datatables.model.JQueryDataTableParamModel;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.copytem.dao.ProdutoDAO;
import br.com.copytem.model.JsonResponse;
import br.com.copytem.model.JsonResponseRow;
import br.com.copytem.model.Produto;

import com.google.gson.JsonArray;

@Resource
public class ProdutoController {

	private final Result result;
	private final ProdutoDAO produtoDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public ProdutoController(Result r, ProdutoDAO p,HttpServletRequest request,HttpServletResponse response) {
		this.result = r;
		this.produtoDAO = p;
		this.request = request;
		this.response = response;
	}

	@Post("/produto/adiciona")
	public void adicionar(Produto produto) {
		produtoDAO.adiciona(produto);
		result.redirectTo(this).listall();

	}
	
	public void deletar(int id) {
		Produto p = produtoDAO.load(id);
		produtoDAO.delete(p);
		result.redirectTo(this).listall();
	}

	public List<Produto> listall() {
		return produtoDAO.loadProdutos();
	}

	public void edita(Produto produto) {
		produtoDAO.atualiza(produto);
		result.redirectTo(this).listall();
	}
	
	@Path("/produto/editar")
	public Produto editar(int id) {
		return produtoDAO.load(id);
	}

	@Path("/produto/form")
	public void form() {

	}
	
	@SuppressWarnings("rawtypes")
	public void search(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		this.request = request;
		this.response = response;
		List<Produto> produtos = new ArrayList<Produto>();
		JsonResponse jr = new JsonResponse();
		List rows = new ArrayList();

		JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
		response.resetBuffer();
		String sEcho = param.sEcho;
		int a;
		String aux = null;
		if(param.sSearch.length() > 1){
			a = param.sSearch.length() - 1;
			aux = (String) param.sSearch.subSequence(0, a );
		}
		
		
		//System.out.println(aux);
		long iTotalRecords; // total number of records (unfiltered)
		int iTotalDisplayRecords; // value will be set when code filters
									// companies by keyword
		JsonArray data = new JsonArray(); // data that will be shown in the
											// table
		iTotalRecords = produtoDAO.count();
		int countSearch = (int) produtoDAO.countSearch(param.sSearch);
		//System.out.println(cdao.countSearch(param.sSearch));
		if (countSearch < 1000) {
			
			//System.out.println("search cdao");
			if (!param.sSearch.isEmpty() || !param.sSearch.equals("")) {
				produtos = produtoDAO.selectLike(param.sSearch);
				
				
			} else {
				produtos = produtoDAO.listAll();
			}
		}else{			
			produtos = produtoDAO.listAll(param.sSearch);			
		}
		iTotalDisplayRecords = produtos.size();
		final int sortColumnIndex = param.iSortColumnIndex;
		final int sortDirection = param.sSortDirection.equals("asc") ? -1 : 1;

		JsonResponse jresponse = new JsonResponse();
		jresponse.setsEcho(sEcho);
		jresponse.setiTotalRecords(iTotalRecords);
		jresponse.setiTotalDisplayRecords(iTotalDisplayRecords);

		if (produtos.size() < param.iDisplayStart + param.iDisplayLength) {
			produtos = produtos.subList(param.iDisplayStart, produtos.size());
		} else {
			produtos = produtos.subList(param.iDisplayStart, param.iDisplayStart + param.iDisplayLength);
		}

		if (produtos.size() < 2000) {
			for (Produto p : produtos) {
				
				String editar = null;
				
			/*	<td>
		          <!-- Adicionando o produto no carrinho de compras -->
		          <form action="<c:url value="/carrinho"/>" method="POST">
		            <input type="hidden" name="item.produto.id" 
		                          value="${produto.id }"/>
		            <input class="qtde" name="item.quantidade" value="1"/>
		            <button type="submit">Comprar</button>
		          </form>
		        </td>*/
		        
		        editar = "<form action=\'/copytem/carrinho\' method=\"POST\">" +
		        		" 	<input type=\"hidden\" name=\"item.produto.id\" " +
		        		" 	value=\"";
		        
		        editar += p.getId();
		        editar +="\"/>" +
		        		" 	<input class=\"\" name=\"item.quantidade\" value=\"01\" style=\"width:40px;\"/> " +
		        		" 	<button type=\"submit\" class=\"\" style=\" border: none; background: none; cursor: pointer;\"><i class=\"icon-shopping-cart\"></i></button> " +
		        		" </form> ";
		       				
				JsonResponseRow jrr = new JsonResponseRow();
				jrr.setId(p.getId());
				jrr.setNome(p.getNome());
				jrr.setUnidadeMedida(p.getUnidadeMedida());
				jrr.setPreco(p.getPreco());
				jrr.setDescricao(p.getDescricao());
				jrr.setLink(editar);
				rows.add(jrr);
			}
		}

		jr.setAaData(rows);
		jr.setsEcho(sEcho);
		jr.setiTotalRecords(iTotalRecords);
		jr.setiTotalDisplayRecords(iTotalDisplayRecords);

		result.use(json()).withoutRoot().from(jr).include("aaData").serialize();
		

	}

}
