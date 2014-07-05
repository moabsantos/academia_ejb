package br.com.msoftware.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.msoftware.servico.Login;

@ManagedBean(name="login")
public class LoginManagedBean {

	@EJB
	private Login ejbLogin;
	
	final String nomeUsuario = "MOAB SANTOS DE FARIAS";

	public String getNomeUsuario() {
		
		return nomeUsuario;
		
	}
	
	public boolean getAutenticacao() {
		
		ejbLogin.salvar();
		return ejbLogin.getAutorizacao("a", "a");
		
	}
	
}
