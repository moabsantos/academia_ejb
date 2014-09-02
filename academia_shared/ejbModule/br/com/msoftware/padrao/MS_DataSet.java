package br.com.msoftware.padrao;

import java.util.List;

public interface MS_DataSet {

	public Long getId();
	
	public MS_DataSet excluir(MS_DataSet obj) throws Exception;
	public MS_DataSet restaurar(MS_DataSet obj) throws Exception;
	public MS_DataSet inativar(MS_DataSet obj) throws Exception;
	public MS_DataSet ativar(MS_DataSet obj) throws Exception;
	
	public MS_DataSet getById(Long i);
	public MS_DataSet getByString(String p_parametro, String p_valor);
	public List<?> listByString(String p_parametro, String p_valor);
	public List<?> listaCompleta();
	public List<?> consultar(MS_DataSet obj) throws IllegalArgumentException, IllegalAccessException;
	
	public MS_DataSet novoObjeto();
	
}
