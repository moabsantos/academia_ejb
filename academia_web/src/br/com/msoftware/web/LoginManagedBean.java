package br.com.msoftware.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.msoftware.padrao.MS_Acesso_Controle;
import br.com.msoftware.padrao.MS_Acesso_Usuario;

@ManagedBean(name="login")
@RequestScoped
public class LoginManagedBean extends PadraoManagedBean {

	@EJB private MS_Acesso_Usuario ejbUsuario;
	
	private String usuario;
	private String senha;

	public String getUsuario() {
		
		return this.usuario;
		
	}
	
	public void setUsuario(String usuario) {
		
		this.usuario = usuario;
		
	}
	
	public String getSenha() {
		
		return senha;
		
	}
	
	public void setSenha(String senha) {
		
		this.senha = senha;
		
	}
	
	public void acessar() throws Exception {

		MS_Acesso_Usuario objUsuario;

		objUsuario = (MS_Acesso_Usuario) ejbUsuario.getByString("nome", this.getUsuario());

		if (objUsuario == null){
			
			objUsuario = (MS_Acesso_Usuario) ejbUsuario.novoObjeto();
			
			if (this.getUsuario().equals("admin")){
				
				objUsuario = (MS_Acesso_Usuario) ejbUsuario.setAutorizacao(this.getUsuario(), this.getSenha(), objUsuario);
				
			}
			
		}
		
		if ( objUsuario.getAutorizacao(this.getUsuario(), this.getSenha()) ) {
			
			addItemSessao("usuario", objUsuario.getId());
			
			String v_ip = this.getmeuIP();
			String v_sessao = this.getminhaSession();
 
			this.setObjAcesso((MS_Acesso_Controle) ejbAcesso.getById(objUsuario.getId()));
			
			this.getObjAcesso().setId(objUsuario.getId());
			
			this.ejbAcesso.setDadosConexao(v_ip, v_sessao, this.getObjAcesso());
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
			
		}else{
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("../../conexao/acesso/usuario_login.xhtml");
			
		}
		
	}
	
}
