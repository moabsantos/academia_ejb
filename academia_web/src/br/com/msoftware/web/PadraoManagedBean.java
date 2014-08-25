package br.com.msoftware.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.msoftware.padrao.MS_Acesso_Controle;
import br.com.msoftware.padrao.MS_DataSet;

public class PadraoManagedBean {

	@EJB protected MS_Acesso_Controle ejbAcesso;
	
	protected MS_Acesso_Controle objAcesso;
	
	@PostConstruct
	 private void init(){
		
		boolean v_usuario_autenticado = false;
		
		if (!getUrl().equals("/academia_web/conexao/acesso/usuario_login.xhtml")){
		
			long v_id_usuario = 0;
			
			if (getItemSessao("usuario") != null){
			
				v_id_usuario = (long) getItemSessao("usuario");
				
			}
			
			if (v_id_usuario != 0){
				
				setObjAcesso((MS_Acesso_Controle) ejbAcesso.getById(v_id_usuario));
					
				if (objAcesso != null){
					
					if (objAcesso.validaDadosConexao(getmeuIP(), getminhaSession())){
						
						v_usuario_autenticado = true;
						
					}
				}
			}
			
		    if (!v_usuario_autenticado){
	
				try {
					
					FacesContext.getCurrentInstance().getExternalContext().redirect("../../conexao/acesso/usuario_login.xhtml");
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
					
			}
			
	    }
		
	}
	
	protected void addMensagem(Severity tipo, String prefixo, String msg){
    	
    	FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(tipo, prefixo, msg));
    	
    }

	protected List<?> listarTodos(MS_DataSet obj){
		
		return obj.listaCompleta();
		
	}
	
	/** Identifica o endereço IP remoto*/
    public String getmeuIP() {
    	
        FacesContext context = FacesContext.getCurrentInstance();
        
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        
        if (ipAddress == null) {
        	
      	   ipAddress = request.getRemoteAddr();
      	   
        }
        
        return ipAddress;  
        
    }
    
    /** Identifica o ID da sessão */
    public String getminhaSession() {
        
    	FacesContext context = FacesContext.getCurrentInstance();
        
    	HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    	
    	if (session == null){
    		
    		session = (HttpSession) context.getExternalContext().getSession(true);
    		
    	}
        
    	if (session != null){
    	
    		return session.getId();
    		
    	}else{
    	
    		return "";
    		
    	}
    	
    }
    
    public String getUrl(){
    	
    	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	
    	return request.getRequestURI().toString();
    	
    }
	
	public void logoff(){
		
		FacesContext fc = FacesContext.getCurrentInstance();  
	    
		HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);  
	    
		session.invalidate();
	       
	}
	
	public static void addItemSessao(String p_nome, Object p_object){  
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(p_nome, p_object);
		
	}
	
	public static Object getItemSessao(String p_nome){  
		
		if(FacesContext.getCurrentInstance() == null){  
			
			return null;
			
		}else{
	
			return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(p_nome);
		
		}
	}
	
	public static void removeItemSessao(String p_nome){  
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(p_nome);
		
	}

	public MS_Acesso_Controle getObjAcesso() {
		
		if (objAcesso != null){
		
		   return objAcesso;
		
		}else{
			
			return (MS_Acesso_Controle) ejbAcesso.novoObjeto();
			
		}
		
	}

	public void setObjAcesso(MS_Acesso_Controle p_objAcesso) {
		
		if (p_objAcesso == null){
			
			objAcesso = (MS_Acesso_Controle) ejbAcesso.novoObjeto();
			
		}else{
		
			objAcesso = p_objAcesso;
			
		}
		
	}
	
	public void doProximaPagina(String p_ProximaPagina) throws IOException{
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(p_ProximaPagina);
		
	}

}
