package br.com.copytem.dao;

import java.util.List;

import org.hibernate.Transaction;


import br.com.caelum.vraptor.ioc.Component;
import br.com.copytem.model.ItemOrdemServico;
import org.hibernate.Session;

@Component
public class ItemOrdemServicoDAO {
	
	private final Session session;
	
	public ItemOrdemServicoDAO(Session session){
		this.session = session;
	}
	
	
	
	public void adiciona(ItemOrdemServico i){
		Transaction tx = session.beginTransaction();
		session.save(i);
		tx.commit();
	}
	
	public void delete(ItemOrdemServico i){
		Transaction tx = session.beginTransaction();
		session.delete(i);
		tx.commit();
	}
	
	public void deletePorId(int id){
		Transaction tx = session.beginTransaction();
		ItemOrdemServico i = (ItemOrdemServico) session.load(ItemOrdemServico.class, id);
		session.delete(i);
		tx.commit();
	}
	
	public ItemOrdemServico load(int id){
		return (ItemOrdemServico) session.load(ItemOrdemServico.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemOrdemServico> loadItemOrdemServicos(){
		return session.createCriteria(ItemOrdemServico.class).list();
	}
}
