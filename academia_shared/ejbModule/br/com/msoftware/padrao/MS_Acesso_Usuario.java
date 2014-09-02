package br.com.msoftware.padrao;

public interface MS_Acesso_Usuario extends MS_Classe_Padrao{
	
	public boolean getAutorizacao(String p_login, String p_senha);
	public MS_DataSet setAutorizacao(String p_login, String p_senha, MS_Acesso_Usuario p_usuario) throws Exception;
	public boolean mudarSenha(String p_login, String p_senha_atual, String p_senha_nova, String p_conf_senha_nova);
	
}
