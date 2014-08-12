package br.com.msoftware.db;

import java.io.IOException;
import java.util.List;

public interface DataSet {

	public Long getId();
	public DataSet salvar(DataSet obj) throws IOException;
	public DataSet getById(Long i);
	public DataSet getByString(String p_parametro, String p_valor);
	public List<?> listByString(String p_parametro, String p_valor);
	public List<?> listaCompleta();
	
	public DataSet novoObjeto();
	
}
