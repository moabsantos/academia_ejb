package br.com.msoftware.padrao;

import br.com.msoftware.db.DataSet;

public interface Login extends DataSet{

	public boolean getAutorizacao(String p_login, String p_senha);
	public boolean setAutorizacao(String p_login, String p_senha);
	public boolean mudarSenha(String p_login, String p_senha_atual, String p_senha_nova, String p_conf_senha_nova);
	
}
