package br.com.copytem.dao;

import java.util.List;

import org.hibernate.Transaction;


import br.com.caelum.vraptor.ioc.Component;
import br.com.copytem.model.ContasReceber;
import org.hibernate.Session;

@Component
public class ContasReceberDAO {
	
	private final Session session;
	
	public ContasReceberDAO(Session session){
		this.session = session;
	}
	
	
	
	public void adiciona(ContasReceber cr){
		Transaction tx = session.beginTransaction();
		session.save(cr);
		tx.commit();
	}
	
	public void delete(ContasReceber cr){
		Transaction tx = session.beginTransaction();
		session.delete(cr);
		tx.commit();
	}
	
	public void deletePorId(int id){
		Transaction tx = session.beginTransaction();
		ContasReceber cr = (ContasReceber) session.load(ContasReceber.class, id);
		session.delete(cr);
		tx.commit();
	}
	
	public ContasReceber load(int id){
		return (ContasReceber) session.load(ContasReceber.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ContasReceber> loadContasRecebers(){
		return session.createCriteria(ContasReceber.class).list();
	}
}
