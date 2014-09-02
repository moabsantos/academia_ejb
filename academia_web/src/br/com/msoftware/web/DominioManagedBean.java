package br.com.msoftware.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import br.com.msoftware.padrao.MS_Acesso_Dominio;

@ManagedBean(name="dominio")
@SessionScoped
public class DominioManagedBean extends PadraoManagedBean {

	@EJB private MS_Acesso_Dominio ejbDominio;

	private MS_Acesso_Dominio objDominio;
	
	private List<?> listaDominios;
	
	public void novo() throws IOException {
		
		this.setObjDominio(null);
		
		this.listaDominios = null;
		
	}
	
	public void consultar() throws IllegalArgumentException, IllegalAccessException{
		
		this.listaDominios = ejbDominio.consultar(this.getObjDominio());
		
	}

	public void salvar() throws Exception{

		ejbDominio.salvar(objDominio, this.getObjAcesso());
		
	}
	
	public void excluir() throws IOException {
		
		try{
		
			this.setObjDominio((MS_Acesso_Dominio) ejbDominio.excluir(this.getObjDominio()));
		
			this.addMensagem( FacesMessage.SEVERITY_WARN, "Welcome ", "Dominio Excluído");
			
		}catch(Exception e){
			
			this.addMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao Excluído: ", e.getMessage());
			
		}
		
	}
	
	public List<?> getListaDominios() throws IllegalArgumentException, IllegalAccessException{
		
		return this.listaDominios;
		
	}

	public MS_Acesso_Dominio getObjDominio() {
		
		if (this.objDominio == null){
		
			this.setObjDominio((MS_Acesso_Dominio) ejbDominio.novoObjeto());
			
		}
		
		return this.objDominio;
	}

	public void setObjDominio(MS_Acesso_Dominio objDominio) {		
		
		this.objDominio = objDominio;
		
	}
	
	
	/* *
	 * 
	 * EVENTOS RELACIONADOS AO FORMULÁRIO
	 * 
	 * */
	
	public void onRowSelect(SelectEvent event) {
		
        this.setObjDominio((MS_Acesso_Dominio) event.getObject());
        
        this.addMensagem(FacesMessage.SEVERITY_INFO,"teste", "s");
        
    }

	
}
