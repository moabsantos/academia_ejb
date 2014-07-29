package br.com.msoftware.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.msoftware.padrao.MS_Dominio;
import br.com.msoftware.servico.Login;

@ManagedBean(name="login")
@RequestScoped
public class LoginManagedBean {

	@EJB private Login ejbLogin;
	@EJB private MS_Dominio ejbDominio;
	
	private String nomeUsuario;
	private String senhaUsuario;
	private List<MS_Dominio> dominios;

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
	
	private void addMensagem(Severity tipo, String msg){
    	
    	FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(tipo, "", msg));
    	
    }
	
	public void save() throws IOException {
		
		Login ejbLogin2 = (Login) ejbLogin.getByString("nome", this.getNomeUsuario());
		
		if (ejbLogin2 == null){
			
			ejbLogin2 = ejbLogin.novoObjeto();
			
		}
		
		ejbLogin2.setAutorizacao(this.getNomeUsuario(), this.getSenhaUsuario());
	    	
        try{
        	
        	ejbLogin.salvar(ejbLogin2);
        	
        	this.addMensagem( FacesMessage.SEVERITY_WARN, "Welcome "+ this.getNomeUsuario());
	        
        }catch(Exception e){
        	
        	this.addMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao salvar: "+ e.getMessage());
        	
        }
		
	}
	
	public void acessar() throws IOException {
		
		Login ejbLogin2 = (Login) ejbLogin.getByString("nome", this.getNomeUsuario());
		
		if (ejbLogin2 == null){
			
			ejbLogin2 = ejbLogin.novoObjeto();
			
		}
		
		this.addMensagem( FacesMessage.SEVERITY_WARN, "Welcome "+ this.getNomeUsuario() + this.getSenhaUsuario());
		
		if ( ejbLogin2.getAutorizacao(this.getNomeUsuario(), this.getSenhaUsuario()) ) {
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
			
		}
		
	}
	
	/*
    public void save() throws IOException {
    	
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	FacesMessage facesMessage = new FacesMessage("This is a message usuario "+ this.getNomeUsuario() + " senha "+ this.getSenhaUsuario());
    	facesContext.addMessage(null, facesMessage);
        
        //FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
    }
	*/
    public void inserir(){ 

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Erro no banco de dados"));

    }
    
    public void fatal() {
    	
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
    
    }
	
	public List<MS_Dominio> listarDominios(){
		
		MS_Dominio ejbDominio2 = (MS_Dominio) ejbDominio.getByString("nome", "Santa Clara");
		
		if (ejbDominio2 == null){
			
			ejbDominio2 = ejbDominio.novoObjeto();
			
			ejbDominio2.atualizar("Santa Clara", "Café1");
			
		}else{
		
			ejbDominio2.atualizar("Santa Clara", "Café2");
		
		}
		
		ejbDominio.salvar(ejbDominio2);
		
		return ejbDominio.listaDominios();
		
	}
	
	public List<MS_Dominio> getDominios(){
		
		if (this.dominios == null) {
			
			this.dominios = this.listarDominios();
			
		}
		
		return this.dominios;
		
	}
	
}
