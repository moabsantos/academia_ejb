package br.com.msoftware.padrao;


public interface MS_Acesso_Controle extends MS_Classe_Padrao{

	public MS_DataSet setDadosConexao(String p_cod_ip, String p_id_sessao, MS_Acesso_Controle p_usuario) throws Exception;
	public boolean validaDadosConexao(String p_cod_ip, String p_id_sessao);
	
}
