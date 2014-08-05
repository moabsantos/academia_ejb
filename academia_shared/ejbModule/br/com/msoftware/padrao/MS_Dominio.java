package br.com.msoftware.padrao;

import br.com.msoftware.db.DataSet;

public interface MS_Dominio  extends DataSet{
	
	public void atualizar(String p_nome, String p_observacao);
	public DataSet getByString(String p_parametro, String p_valor);
	
}
