package br.com.copytem.dao;

import java.util.List;

import org.hibernate.Transaction;


import br.com.caelum.vraptor.ioc.Component;
import br.com.copytem.model.Pagamento;
import org.hibernate.Session;

@Component
public class PagamentoDAO {
	
	private final Session session;
	
	public PagamentoDAO(Session session){
		this.session = session;
	}
	
	
	
	public void adiciona(Pagamento p){
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
	}
	
	public void delete(Pagamento p){
		Transaction tx = session.beginTransaction();
		session.delete(p);
		tx.commit();
	}
	
	public void deletePorId(int id){
		Transaction tx = session.beginTransaction();
		Pagamento p = (Pagamento) session.load(Pagamento.class, id);
		session.delete(p);
		tx.commit();
	}
	
	public Pagamento load(int id){
		return (Pagamento) session.load(Pagamento.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pagamento> loadPagamentos(){
		return session.createCriteria(Pagamento.class).list();
	}
}
