package br.com.msoftware.db;

import java.util.List;

public interface DataSet {

	public DataSet salvar(DataSet obj);
	public DataSet getById(Long i);
	public DataSet getByString(String p_parametro, String p_valor);
	public List<?> listByString(String p_parametro, String p_valor);
	public List<?> listaCompleta();
	
	public DataSet novoObjeto();
	
}
