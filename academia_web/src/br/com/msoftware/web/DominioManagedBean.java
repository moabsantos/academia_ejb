package br.com.msoftware.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import br.com.msoftware.padrao.MS_Acesso_Dominio;

@ManagedBean(name="dominio")
@ViewScoped
public class DominioManagedBean extends PadraoManagedBean {

	@EJB private MS_Acesso_Dominio ejbDominio;
	
	private MS_Acesso_Dominio objDominio;
	
	private List<?> listaDominios;

	public void novo() throws IOException {
		
		this.setObjDominio(null);
		
	}

	public void salvar() throws Exception{
		
		ejbDominio.salvar(objDominio, this.getObjAcesso());
		
	}
	
	public void excluir() throws IOException {
		
		try{
		
			this.setObjDominio((MS_Acesso_Dominio) ejbDominio.excluir(this.getObjDominio()));
		
			this.addMensagem( FacesMessage.SEVERITY_WARN, "Welcome ", "Dominio Salvo");
			
		}catch(Exception e){
			
			this.addMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao salvar: ", e.getMessage());
			
		}
		
	}
	
	public List<?> getListaDominios(){
		
		this.listaDominios = ejbDominio.listaCompleta();
		
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
        
    }

	
}
