package br.com.msoftware.servico;

import br.com.msoftware.db.DataSet;

public interface Login extends DataSet{

	public Login novoObjeto();
	public boolean getAutorizacao(String p_login, String p_senha);
	public boolean setAutorizacao(String p_login, String p_senha);
	public boolean mudarSenha(String p_login, String p_senha_atual, String p_senha_nova);
	public boolean getUsuarios(String p_login, String p_senha_atual, String p_senha_nova);
	public Login getByString(String p_parametro, String p_valor);
	
}
