package br.com.msoftware.db;

import java.util.List;

public interface DataSet {

	public boolean salvar();
	boolean salvar(DataSet obj);
	public DataSet getById(Long i);
	public DataSet getByString(String p_tabela, String p_parametro, String p_valor);
	public List<DataSet> listByString(String p_tabela, String p_parametro, String p_valor);
	
	public DataSet novoObjeto();
	
}
