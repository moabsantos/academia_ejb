package br.com.msoftware.servico;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

import br.com.msoftware.servico.Login;

@Stateless
@Entity
public class LoginImpl implements Login {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Id
	@GeneratedValue
	private Long id;
	
	@Override
	public boolean getAutorizacao(String p_login, String p_senha) {
		return p_login == p_senha;
	}

	@Override
	public boolean salvar() {
		entityManager.persist(this);
		return false;
	}
}
