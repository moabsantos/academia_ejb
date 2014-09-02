package br.com.msoftware.padrao;

import javax.ejb.Stateless;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Stateless
@Entity @Table(name="SEGUR_0007")
@SequenceGenerator(name = "usuario", sequenceName = "sequencia", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name="ID"))
public class MS_Acesso_Usuario_Impl extends MS_Classe_Padrao_Impl implements MS_Acesso_Usuario {
	
	private String senha;
	
	@Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	public Long getId(){
		
		return id;
		
	}
	
	@Override
	public MS_Classe_Padrao_Impl novoObjeto() {

		return new MS_Acesso_Usuario_Impl();
		
	}

	public boolean getAutorizacao(String p_login, String p_senha) {
		
		return (p_login.equals(this.getNome())) && (p_senha.equals(this.getSenha()));
		
	}	
	
	public MS_Acesso_Usuario_Impl setAutorizacao(String p_login, String p_senha, MS_Acesso_Usuario p_usuario) throws Exception {
		
		((MS_Acesso_Usuario_Impl) p_usuario).setNome(p_login);
		((MS_Acesso_Usuario_Impl) p_usuario).setSenha(p_senha);

		return (MS_Acesso_Usuario_Impl) super.salvar(p_usuario, p_usuario);
		
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
	
}
