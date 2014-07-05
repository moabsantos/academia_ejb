package br.com.msoftware.autenticacao;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Stateless
@Entity
public class Login implements I_Login {

	@Id
	@GeneratedValue
	private Long id;
	
	@Override
	public boolean getAutorizacao(String p_login, String p_senha) {
	
		return p_login == p_senha;
	}

	@Override
	public boolean salvar() {

		EntityManagerFactory factory =
				   Persistence.createEntityManagerFactory("dbpoee");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();    
		manager.persist(this);
		manager.getTransaction().commit(); 		
		
		return false;
	}
	


}
