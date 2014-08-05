package br.com.msoftware.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;

import br.com.msoftware.padrao.MS_Dominio;

@ManagedBean(name="dominio")
@RequestScoped
public class DominioManagedBean extends PadraoManagedBean {

	@EJB private MS_Dominio ejbDominio;
	private List<?> listaDominios;
	private MS_Dominio objDominio;
	
	public void salvar(){	
	    	
        try{
        	
        	this.setObjDominio((MS_Dominio) ejbDominio.salvar(this.getObjDominio()));
    			
    		this.addMensagem( FacesMessage.SEVERITY_WARN, "Welcome ", "Dominio Salvo");
	        
        }catch(Exception e){
        	
        	this.addMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao salvar: ", e.getMessage());
        	
        }
		
	}

	public void novo() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void cancelar() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void excluir() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	public List<?> getListaDominios(){
		
		this.listaDominios = ejbDominio.listaCompleta();
		
		return this.listaDominios;
		
	}

	public MS_Dominio getObjDominio() {
		
		if (this.objDominio == null){
			
			this.setObjDominio((MS_Dominio) ejbDominio.novoObjeto());
			
		}
		
		return this.objDominio;
	}

	public void setObjDominio(MS_Dominio objDominio) {
		
		this.addMensagem( FacesMessage.SEVERITY_WARN, "Welcome ", "SET 1");
		
		this.objDominio = objDominio;
		
		this.addMensagem( FacesMessage.SEVERITY_WARN, "Welcome ", "SET 2");
		
	}
	
	public void onRowSelect(SelectEvent event) {
		
        this.setObjDominio((MS_Dominio) event.getObject());
        
    }

	
}
