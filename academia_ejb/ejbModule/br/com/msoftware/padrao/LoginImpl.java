package br.com.msoftware.padrao;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.msoftware.db.DataSetImpl;
import br.com.msoftware.padrao.Login;

@Stateless
@Entity
@Table(name="SEGUR_0001")
public class LoginImpl extends DataSetImpl implements Login {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String senha;
	private String observacao;

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

	public boolean mudarSenha(String p_login, String p_senha_atual,
			String p_senha_nova, String p_conf_senha_nova) {

		if (this.getAutorizacao(p_login, p_senha_atual)){
			
			if (p_senha_nova.equals(p_conf_senha_nova)){
				
				return this.getAutorizacao(p_login, p_conf_senha_nova);
				
			}else{
			
				return false;
				
			}
			
		}else{
		
			return false;
			
		}
	}

	public String getObservacao() {
		
		return observacao;
		
	}

	public void setObservacao(String observacao) {
		
		this.observacao = observacao;
		
	}

	public boolean getAutorizacao(String p_login, String p_senha) {
		
		return (p_login.equals(this.getNome())) && (p_senha.equals(this.getSenha()));
		
	}	
	
	public boolean setAutorizacao(String p_login, String p_senha) {
		
		this.setNome(p_login);
		this.setSenha(p_senha);
		
		return true;
	}

	public LoginImpl novoObjeto() {
		
		return new LoginImpl();
		
	}
	
}
