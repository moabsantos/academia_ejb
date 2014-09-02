package br.com.msoftware.padrao;

public interface MS_Classe_Padrao extends MS_DataSet {

	public Long getId();
	public void setId(Long id);
	public MS_Classe_Padrao salvar(MS_Classe_Padrao p_obj, MS_Classe_Padrao p_conexao) throws Exception;
	
}
