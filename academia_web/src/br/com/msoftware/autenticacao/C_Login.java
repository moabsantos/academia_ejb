package br.com.msoftware.autenticacao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="login")
public class C_Login {

	@EJB
	private I_Login ejbLogin;
	
	final String nomeUsuario = "MOAB SANTOS DE FARIAS";

	public String getNomeUsuario() {
		
		return nomeUsuario;
		
	}
	
	public boolean getAutenticacao() {
		
		ejbLogin.salvar();
		return ejbLogin.getAutorizacao("a", "a");
		
	}
	
}
