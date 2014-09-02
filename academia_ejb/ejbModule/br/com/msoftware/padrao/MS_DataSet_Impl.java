package br.com.msoftware.padrao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
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

	private boolean fieldConsulta(Field field){
		
		if (field.getName().contains("_")){
			
			return false;
			
		}else{
			
			if (field.getType().equals(String.class)){
				
				return true;
				
			}else{
			
				if (field.getType().equals(Long.class)){
					
					return true;
					
				}else{
				
					return false;
					
				}
				
			}
			
		}
		
	}
	
	private boolean fieldVasio(Field field, MS_DataSet obj) throws IllegalArgumentException, IllegalAccessException{
		
		if (field.get(obj) == null){
			
			return true;
			
		}else{
			
			if (field.get(obj).toString() == null){
				
				return true;
				
			}else{
				
				if (field.get(obj).toString().equals("")){
					
					return true;
					
				}else{
					
					return false; 
					
				}
				
			}
				
			
		}
		
	}
	
	public List<?> consultar(MS_DataSet obj) throws IllegalArgumentException, IllegalAccessException{
		
		if (obj == null){
			
			return null;
			
		}
		
		List<Field> attributes = findAllFields(obj.getClass());
		String txtWhere = "";

        for (Field field : attributes) {
            
        	if (fieldConsulta(field)){
        		
        		if (!fieldVasio(field, obj)){

        			if (field.getType().equals(String.class)){
        				
        				if(field.get(obj).toString().contains("%")){
        					
        					txtWhere = txtWhere + " and e."+ field.getName() +" like :" + field.getName();
        					
        				}else{
        					
        					txtWhere = txtWhere + " and e."+ field.getName() +" = :" + field.getName();
        					
        				}
        				
        			}else{
	        		
        				txtWhere = txtWhere + " and e."+ field.getName() +" = :" + field.getName();
        				
        			}
        			
        		}
        	}
		}
        
        Query q = entityManager.createQuery("SELECT e FROM " + obj.getClass().getSimpleName() + " e WHERE 1=1 "+ txtWhere);
        
        for (Field field : attributes) {
            
        	if (fieldConsulta(field)){
        		
        		if (!fieldVasio(field, obj)){

		        	q.setParameter(field.getName(), field.get(obj));
		        	
        		}
        	}
		}
		
		return q.getResultList();
		
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
	
	private static List<Field> findAllFields(Class<?> metaClass) {
	    List<Field[]> fields = new ArrayList<Field[]>();
	    findFields(metaClass, fields);

	    List<Field> allFields = new ArrayList<Field>();
	    for(Field[] f : fields) {
	        List<Field> asList = Arrays.asList(f);
	        allFields.addAll(asList);
	    }
	    return allFields;
	}

	private static void findFields(Class<?> metaClass2, List<Field[]> fields) {
	    Class<?> next = metaClass2;
	    while(true) {
	        Field[] f = next.getDeclaredFields();
	        fields.add(f);
	        next = next.getSuperclass();
	        if(next.equals(MS_DataSet_Impl.class))
	            return;
	    }
	}
}
