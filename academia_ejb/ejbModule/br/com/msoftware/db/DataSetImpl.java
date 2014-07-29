package br.com.msoftware.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DataSetImpl implements DataSet {

	@PersistenceContext(name="dbpoee")
	protected EntityManager entityManager;
	
	@Override
	public boolean salvar(DataSet obj) {
		
		entityManager.merge(obj);
		
		return false;
		
	}

	@Override
	public boolean salvar() {
		
		return false;
	}

	@Override
	public DataSetImpl getById(Long p_id) {
		
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public DataSet getByString(String p_tabela, String p_parametro, String p_valor) {
		try{
			
			Query q = entityManager.createQuery("SELECT e FROM " + p_tabela + " e WHERE e."+  p_parametro +" = :" + p_parametro);
		
			q.setParameter(p_parametro, p_valor);
		
			return (DataSet) q.getSingleResult();
		
		}catch(Exception e){
	        
	        return null;
			
		}
	}

	@Override
	public List listByString(String p_tabela, String p_parametro,
			String p_valor) {

		Query q = entityManager.createQuery("SELECT e FROM " + p_tabela + " e WHERE e."+  p_parametro +" = :" + p_parametro);
		
		q.setParameter(p_parametro, p_valor);
		
		return q.getResultList();
	}

	@Override
	public DataSet novoObjeto() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
