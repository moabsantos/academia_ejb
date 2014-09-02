package br.com.msoftware.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import br.com.msoftware.padrao.MS_Estoque_Unidade_Medida;

@ManagedBean(name="unidademedida")
@SessionScoped
public class UnidadeMedidaMB extends PadraoManagedBean {

	@EJB private MS_Estoque_Unidade_Medida ejbUnidadeMedida;

	private MS_Estoque_Unidade_Medida objUnidadeMedida;
	
	private List<?> listaUnidadeMedida;
	
	public void novo() throws IOException {
		
		this.setObjUnidadeMedida(null);
		
		this.listaUnidadeMedida = null;
		
	}
	
	public void consultar() throws IllegalArgumentException, IllegalAccessException{
		
		this.listaUnidadeMedida = ejbUnidadeMedida.consultar(this.getObjUnidadeMedida());
		
	}

	public void salvar() throws Exception{

		ejbUnidadeMedida.salvar(objUnidadeMedida, this.getObjAcesso());
		
	}
	
	public void excluir() throws IOException {
		
		try{
		
			this.setObjUnidadeMedida((MS_Estoque_Unidade_Medida) ejbUnidadeMedida.excluir(this.getObjUnidadeMedida()));
		
			this.addMensagem( FacesMessage.SEVERITY_WARN, "Welcome ", "Dominio Excluído");
			
		}catch(Exception e){
			
			this.addMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao Excluído: ", e.getMessage());
			
		}
		
	}
	
	public List<?> getListaUnidadeMedida() throws IllegalArgumentException, IllegalAccessException{
		
		return this.listaUnidadeMedida;
		
	}

	public MS_Estoque_Unidade_Medida getObjUnidadeMedida() {
		
		if (this.objUnidadeMedida == null){
		
			this.setObjUnidadeMedida((MS_Estoque_Unidade_Medida) ejbUnidadeMedida.novoObjeto());
			
		}
		
		return this.objUnidadeMedida;
	}

	public void setObjUnidadeMedida(MS_Estoque_Unidade_Medida objUnidadeMedida) {		
		
		this.objUnidadeMedida = objUnidadeMedida;
		
	}
	
	
	/* *
	 * 
	 * EVENTOS RELACIONADOS AO FORMULÁRIO
	 * 
	 * */
	
	public void onRowSelect(SelectEvent event) {
		
        this.setObjUnidadeMedida((MS_Estoque_Unidade_Medida) event.getObject());
        
        this.addMensagem(FacesMessage.SEVERITY_INFO,"teste", "s");
        
    }
	
}
