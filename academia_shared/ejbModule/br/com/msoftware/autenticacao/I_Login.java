package br.com.msoftware.autenticacao;

import br.com.msoftware.db.I_DataSet;

public interface I_Login extends I_DataSet {

	public boolean getAutorizacao(String p_login, String p_senha);
	
}
