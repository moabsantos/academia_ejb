package br.com.msoftware.web;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import br.com.msoftware.db.DataSet;

public abstract class PadraoManagedBean {

	protected void addMensagem(Severity tipo, String prefixo, String msg){
    	
    	FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(tipo, prefixo, msg));
    	
    }
	
	public abstract void novo()  throws IOException;
	public abstract void salvar()  throws IOException;
	public abstract void cancelar()  throws IOException;
	public abstract void excluir()  throws IOException;
	protected List<?> listarTodos(DataSet obj){
		
		return obj.listaCompleta();
		
	}
	 
	
}
