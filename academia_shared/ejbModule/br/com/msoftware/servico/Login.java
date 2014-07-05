package br.com.msoftware.servico;

import br.com.msoftware.db.DataSet;

public interface Login extends DataSet {

	public boolean getAutorizacao(String p_login, String p_senha);
	
}
