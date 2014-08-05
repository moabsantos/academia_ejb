package br.com.msoftware.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class DataSetImpl implements DataSet {

	@PersistenceContext(name="dbpoee")
	protected EntityManager entityManager;
	

	public DataSetImpl salvar(DataSet obj) {
		
		entityManager.merge(obj);
		
		entityManager.flush();
		
		return (DataSetImpl) obj;
		
	}


	public DataSet getById(Long p_id) {
		
		try{
			
			Query q = entityManager.createQuery("SELECT e FROM " + this.getClass().getSimpleName() + " e WHERE e.id = :" + p_id);
		
			return (DataSet) q.getSingleResult();
		
		}catch(Exception e){
	        
	        return null;
			
		}
		
	}


	public DataSetImpl getByString(String p_parametro, String p_valor) {
		
		try{
			
			Query q = entityManager.createQuery("SELECT e FROM " + this.getClass().getSimpleName() + " e WHERE e."+  p_parametro +" = :" + p_parametro);
		
			q.setParameter(p_parametro, p_valor);
		
			return (DataSetImpl) q.getSingleResult();
		
		}catch(Exception e){
	        
	        return null;
			
		}
	}


	public List<?> listByString(String p_parametro,
			String p_valor) {

		Query q = entityManager.createQuery("SELECT e FROM " + this.getClass().getSimpleName() + " e WHERE e."+  p_parametro +" = :" + p_parametro);
		
		q.setParameter(p_parametro, p_valor);
		
		return q.getResultList();
		
	}

	public List<?> listaCompleta() {

		Query q = entityManager.createQuery("SELECT e FROM " + this.getClass().getSimpleName() + " e");
		
		return q.getResultList();
	}
	
}
