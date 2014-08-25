package br.com.msoftware.padrao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.msoftware.padrao.MS_DataSet;


public abstract class MS_DataSet_Impl implements MS_DataSet {
	
	@PersistenceContext(name="dbpoee")
	protected EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		
	    return this.entityManager;
	    
	}
	
	public MS_DataSet_Impl salvar(MS_DataSet obj) throws Exception {
		
		if (obj != null){
		
			if (obj.getId() == null) {
				
				getEntityManager().persist(obj);
			
			}else{
				
				getEntityManager().merge(obj);
				
			}
			
			getEntityManager().flush();
			getEntityManager().clear();
					
			return (MS_DataSet_Impl) obj;
		
		}else{
			
			return null;
			
		}
		
	}
	
	public MS_DataSet_Impl getById(Long p_id) {

		try{
			
			if (p_id != null){
			
				Query q = entityManager.createQuery("SELECT e FROM " + this.getClass().getSimpleName() + " e WHERE e.id = " + p_id);
			
				return (MS_DataSet_Impl) q.getSingleResult();
			
			}else{
				
				return null;
				
			}
		
		}catch(Exception e){
	        
	        return null;
			
		}

	}


	public MS_DataSet_Impl getByString(String p_parametro, String p_valor) {
		
		try{
			
			Query q = entityManager.createQuery("SELECT e FROM " + this.getClass().getSimpleName() + " e WHERE e."+  p_parametro +" = :" + p_parametro);
		
			q.setParameter(p_parametro, p_valor);
		
			return (MS_DataSet_Impl) q.getSingleResult();
		
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

		Query q = entityManager.createQuery("SELECT e FROM " + this.getClass().getSimpleName() + " e WHERE e.flag_excluido = 0");
		
		return q.getResultList();
	}
	
	public MS_DataSet excluir(MS_DataSet obj) throws Exception{
		
		return this.salvar(obj);
		
	};
	
	public MS_DataSet restaurar(MS_DataSet obj) throws Exception{
		
		return this.salvar(obj);
		
	};
	
	public MS_DataSet inativar(MS_DataSet obj) throws Exception {
		
		return this.salvar(obj);
		
	};
	
	public MS_DataSet ativar(MS_DataSet obj) throws Exception{
		
		return this.salvar(obj);
		
	};
}
