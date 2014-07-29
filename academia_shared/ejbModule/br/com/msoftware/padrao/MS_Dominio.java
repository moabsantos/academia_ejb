package br.com.msoftware.padrao;

import java.util.List;

import br.com.msoftware.db.DataSet;

public interface MS_Dominio  extends DataSet{
	
	public MS_Dominio novoObjeto();
	public void atualizar(String p_nome, String p_observacao);
	public List<MS_Dominio> listaDominios();
	public DataSet getByString(String p_parametro, String p_valor);
	
}
