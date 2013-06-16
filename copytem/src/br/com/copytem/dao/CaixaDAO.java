package br.com.copytem.dao;

import java.util.List;

import org.hibernate.Transaction;


import br.com.caelum.vraptor.ioc.Component;
import br.com.copytem.model.Caixa;
import org.hibernate.Session;

@Component
public class CaixaDAO {
	
	private final Session session;
	
	public CaixaDAO(Session session){
		this.session = session;
	}
	
	
	
	public void adiciona(Caixa c){
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();
	}
	
	public void delete(Caixa c){
		Transaction tx = session.beginTransaction();
		session.delete(c);
		tx.commit();
	}
	
	public void deletePorId(int id){
		Transaction tx = session.beginTransaction();
		Caixa c = (Caixa) session.load(Caixa.class, id);
		session.delete(c);
		tx.commit();
	}
	
	public void atualiza(Caixa c){
		Transaction tx = session.beginTransaction();
		session.update(c);
		tx.commit();
	}
	
	public Caixa load(int id){
		return (Caixa) session.load(Caixa.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Caixa> loadCaixas(){
		return session.createCriteria(Caixa.class).list();
	}
}
