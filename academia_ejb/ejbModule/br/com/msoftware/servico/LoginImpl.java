package br.com.msoftware.servico;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.msoftware.db.DataSetImpl;
import br.com.msoftware.servico.Login;

@Stateless
@Entity(name="SEGUR_0001")
public class LoginImpl extends DataSetImpl implements Login {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String senha;
	private String observacao;
	
	public boolean getAutorizacao(String p_login, String p_senha) {
		
		return (p_login.equals(this.getNome())) && (p_senha.equals(this.getSenha()));
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
		
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public LoginImpl getById(Long p_id) {
		
		return entityManager.find(LoginImpl.class, p_id);
		
	}

	@Override
	public boolean mudarSenha(String p_login, String p_senha_atual,
			String p_senha_nova) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUsuarios(String p_login, String p_senha_atual,
			String p_senha_nova) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public LoginImpl novoObjeto() {

		return new LoginImpl();
		
	}

	@Override
	public LoginImpl getByString(String p_parametro, String p_valor) {

		return (LoginImpl) getByString("SEGUR_0001", p_parametro, p_valor);
		
	}


	public boolean setAutorizacao(String p_login, String p_senha) {
		
		this.setNome(p_login);
		this.setSenha(p_senha);
		
		return true;
	}
}
