package br.com.copytem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.copytem.model.Produto;

@Component
public class ProdutoDAO {
	
	private final Session session;
	
	public ProdutoDAO(Session session){
		this.session = session;
	}
	
	
	
	public void adiciona(Produto p){
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
	}
	
	public void delete(Produto p){
		Transaction tx = session.beginTransaction();
		session.delete(p);
		tx.commit();
	}
	
	public void deletePorId(int id){
		Transaction tx = session.beginTransaction();
		Produto p = (Produto) session.load(Produto.class, id);
		session.delete(p);
		tx.commit();
	}
	
	public void atualiza(Produto p){
		Transaction tx = session.beginTransaction();
		session.update(p);
		tx.commit();
	}
	
	public Produto load(int id){
		return (Produto) session.load(Produto.class, id);
	}
	

	@SuppressWarnings("unchecked")
	public List<Produto> loadProdutos(){
		return session.createCriteria(Produto.class).list();
	}



	public long count() {
		Query q = session.createQuery("select count(*) from Produto");  
		return (Long) q.uniqueResult();
	}



	public long countSearch(String c) {
		return (Long) session.createQuery("select count(*) from Produto c where c.nome like :nome").setParameter("nome", MatchMode.ANYWHERE.toMatchString(c)).uniqueResult();
	}


	@SuppressWarnings("unchecked")
	public List<Produto> selectLike(String sSearch) {
		return session.createCriteria(Produto.class).add(Restrictions.ilike("nome", sSearch, MatchMode.ANYWHERE)).list();
	}



	@SuppressWarnings("unchecked")
	public List<Produto> listAll() {
		 Criteria sql = this.session.createCriteria(Produto.class);
		 sql.addOrder(Order.asc("id"));
		 sql.setMaxResults(10);
		 return sql.list();
	}



	@SuppressWarnings("unchecked")
	public List<Produto> listAll(String sSearch) {
		 Criteria sql = this.session.createCriteria(Produto.class);
		 sql.addOrder(Order.asc("nome"));
		 sql.add(Restrictions.ilike("nome", sSearch, MatchMode.ANYWHERE));
		 sql.setMaxResults(50);
		 return sql.list();
	}


	public void recarrega(Produto produto) {
		System.out.println(produto.toString());
		session.refresh(produto);		
	}
}
