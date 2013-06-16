package br.com.copytem.model;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Carrinho {

	private List<Item> itens = new ArrayList<Item>();
	private Cliente cliente = new Cliente();
	private Double total = 0.0;

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void adiciona(Item item) {
		itens.add(item);
		total += item.getProduto().getPreco() * item.getQuantidade();
	}

	public Integer getTotalDeItens() {
		return itens.size();
	}

	public void remove(int indiceItem) {
	    Item removido = itens.remove(indiceItem);
	    total -= removido.getProduto().getPreco() * removido.getQuantidade();
	  }

}
