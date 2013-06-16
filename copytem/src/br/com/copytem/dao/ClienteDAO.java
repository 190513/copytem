package br.com.copytem.dao;

import java.util.List;

import org.hibernate.Transaction;


import br.com.caelum.vraptor.ioc.Component;
import br.com.copytem.model.Cliente;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

@Component
public class ClienteDAO {
	
	private final Session session;
	
	public ClienteDAO(Session session){
		this.session = session;
	}
	
	
	
	public void adiciona(Cliente c){
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();
	}
	
	public void delete(Cliente c){
		Transaction tx = session.beginTransaction();
		session.delete(c);
		tx.commit();
	}
	
	public void deletePorId(int id){
		Transaction tx = session.beginTransaction();
		Cliente c = (Cliente) session.load(Cliente.class, id);
		session.delete(c);
		tx.commit();
	}
	
	public void atualiza(Cliente c){
		Transaction tx = session.beginTransaction();
		session.update(c);
		tx.commit();
	}
	
	public Cliente load(int id){
		return (Cliente) session.load(Cliente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> loadClientes(){
		return session.createCriteria(Cliente.class).list();
	}



	@SuppressWarnings("unchecked")
	public List<Cliente> busca(String q) {
		System.out.println(q);
		return session.createCriteria(Cliente.class).add(Restrictions.ilike("nome", q, MatchMode.ANYWHERE)).list();
	
	}
}
