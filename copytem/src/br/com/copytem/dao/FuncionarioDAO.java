package br.com.copytem.dao;

import java.util.List;

import org.hibernate.Transaction;


import br.com.caelum.vraptor.ioc.Component;
import br.com.copytem.model.Funcionario;
import org.hibernate.Session;

@Component
public class FuncionarioDAO {
	
	private final Session session;
	
	public FuncionarioDAO(Session session){
		this.session = session;
	}
	
	
	
	public void adiciona(Funcionario f){
		Transaction tx = session.beginTransaction();
		session.save(f);
		tx.commit();
	}
	
	public void delete(Funcionario f){
		Transaction tx = session.beginTransaction();
		session.delete(f);
		tx.commit();
	}
	
	public void deletePorId(int id){
		Transaction tx = session.beginTransaction();
		Funcionario f = (Funcionario) session.load(Funcionario.class, id);
		session.delete(f);
		tx.commit();
	}
	
	public void atualiza(Funcionario f){
		Transaction tx = session.beginTransaction();
		session.update(f);
		tx.commit();
	}
	
	public Funcionario load(int id){
		return (Funcionario) session.load(Funcionario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> loadFuncionarios(){
		return session.createCriteria(Funcionario.class).list();
	}
}
