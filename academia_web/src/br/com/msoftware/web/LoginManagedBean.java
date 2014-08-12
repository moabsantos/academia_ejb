package br.com.msoftware.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.msoftware.padrao.Login;
import br.com.msoftware.padrao.MS_Dominio_Empresas;

@ManagedBean(name="login")
@RequestScoped
public class LoginManagedBean extends PadraoManagedBean {

	@EJB private Login ejbLogin;
	@EJB private MS_Dominio_Empresas ejbDominio;
	
	private String nomeUsuario;
	private String senhaUsuario;
	private List<?> dominios;

	public String getNomeUsuario() {
		
		return this.nomeUsuario;
		
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		
		this.nomeUsuario = nomeUsuario;
		
	}
	
	public String getSenhaUsuario() {
		
		return senhaUsuario;
		
	}
	
	public void setSenhaUsuario(String senhaUsuario) {
		
		this.senhaUsuario = senhaUsuario;
		
	}
	
	public void salvar(){
		
		Login ejbLogin2 = (Login) ejbLogin.getByString("nome", this.getNomeUsuario());
		
		if (ejbLogin2 == null){
			
			ejbLogin2 = (Login) ejbLogin.novoObjeto();
			
		}
	    	
        try{
        	
        	if (ejbLogin2 != null){
    			
    			if (ejbLogin2.setAutorizacao(this.getNomeUsuario(), this.getSenhaUsuario())){
    			
    				ejbLogin.salvar(ejbLogin2);
    			
    				this.addMensagem( FacesMessage.SEVERITY_WARN, "Welcome ", this.getNomeUsuario());
    				
    			}
    			
    		}else{
    			
    			this.addMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao salvar: ", "Motivo não identificado");
    			
    		}
        	
	        
        }catch(Exception e){
        	
        	this.addMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao salvar: ", e.getMessage());
        	
        }
		
	}
	
	public void acessar() throws IOException {
		
		Login ejbLogin2 = (Login) ejbLogin.getByString("nome", this.getNomeUsuario());
		
		if (ejbLogin2 == null){
			
			ejbLogin2 = (Login) ejbLogin.novoObjeto();
			
		}
		
		this.addMensagem( FacesMessage.SEVERITY_WARN, "Welcome ", this.getNomeUsuario() + this.getSenhaUsuario());
		
		if ( ejbLogin2.getAutorizacao(this.getNomeUsuario(), this.getSenhaUsuario()) ) {
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
			
		}
		
	}
	
	public List<?> getDominios(){
		
		if (this.dominios == null) {			
			
			this.dominios = ejbDominio.listaCompleta();
			
		}
		
		return this.dominios;
		
	}
	
	@Override
	public void novo() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelar() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
