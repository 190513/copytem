package br.com.copytem.dao;

import java.util.List;

import org.hibernate.Transaction;


import br.com.caelum.vraptor.ioc.Component;
import br.com.copytem.model.OrdemServico;
import org.hibernate.Session;

@Component
public class OrdemServicoDAO {
	
	private final Session session;
	
	public OrdemServicoDAO(Session session){
		this.session = session;
	}
	
	
	
	public void adiciona(OrdemServico os){
		Transaction tx = session.beginTransaction();
		session.save(os);
		tx.commit();
	}
	
	public void delete(OrdemServico os){
		Transaction tx = session.beginTransaction();
		session.delete(os);
		tx.commit();
	}
	
	public void deletePorId(int id){
		Transaction tx = session.beginTransaction();
		OrdemServico os = (OrdemServico) session.load(OrdemServico.class, id);
		session.delete(os);
		tx.commit();
	}
	
	public OrdemServico load(int id){
		return (OrdemServico) session.load(OrdemServico.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdemServico> loadOrdemServicos(){
		return session.createCriteria(OrdemServico.class).list();
	}
}
