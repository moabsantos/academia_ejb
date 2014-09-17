package br.com.msoftware.padrao;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class MS_Classe_Padrao_Impl extends MS_DataSet_Impl implements MS_Classe_Padrao {

	protected Long id;
	protected String nome;
	protected String sigla;
	protected String nome_reduzido;
	protected String observacao;
	
	protected int flag_ativo;
	protected int flag_cadastrado;
	protected int flag_excluido;
	
	public abstract MS_Classe_Padrao_Impl novoObjeto();
	
	public int getFlag_ativo() {
		
		return flag_ativo;
		
	}

	public void setFlag_ativo(int flag_ativo) {
		
		this.flag_ativo = flag_ativo;
		
	}

	public int getFlag_cadastro() {
		
		return flag_cadastrado;
		
	}

	public void setFlag_cadastro(int flag_cadastro) {
		
		this.flag_cadastrado = flag_cadastro;
		
	}

	public int getFlag_excluido() {
		
		return flag_excluido;
		
	}

	public void setFlag_excluido(int flag_excluido) {
		
		this.flag_excluido = flag_excluido;
		
	}
	
	public Long getId() {
		
		return id;
		
	}

	public void setId(Long id) {
		
		this.id = id;
		
	}
	
	public String getNome() {
		
		return this.nome;
		
	}

	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
	public String getObservacao() {
		
		return observacao;
		
	}

	public void setObservacao(String observacao) {
		
		this.observacao = observacao;
		
	}
	
	@Override
	public MS_DataSet excluir(MS_DataSet obj) throws Exception{
		
		((MS_Classe_Padrao_Impl) obj).setFlag_excluido(1);
		
		return (MS_DataSet) super.excluir(obj);
		
	};
	
	@Override
	public MS_DataSet restaurar(MS_DataSet obj) throws Exception{
		
		((MS_Classe_Padrao_Impl) obj).setFlag_excluido(0);
		
		return (MS_DataSet) super.restaurar(obj);
		
	};
	
	@Override
	public MS_DataSet inativar(MS_DataSet obj) throws Exception{
		
		((MS_Classe_Padrao_Impl) obj).setFlag_ativo(0);
		
		return (MS_DataSet) super.inativar(obj);
		
	};
	
	@Override
	public MS_DataSet ativar(MS_DataSet obj) throws Exception {
		
		((MS_Classe_Padrao_Impl) obj).setFlag_ativo(1);
		
		return (MS_DataSet) super.ativar(obj);
		
	};

	public MS_Classe_Padrao salvar(MS_Classe_Padrao p_obj,
			MS_Classe_Padrao p_conexao) throws Exception {
		
		boolean v_evento_autorizado = false;
		
		if (p_conexao != null){
			
			v_evento_autorizado = true;
			
			if (p_conexao.getId() != null){
				
				v_evento_autorizado = true;
				
			}
			
		}
		
		if(v_evento_autorizado){
			
			return (MS_Classe_Padrao_Impl) super.salvar(p_obj);
			
		}else{
		
			return p_obj;
			
		}
		
	}

	public String getSigla() {
		
		return sigla;
		
	}

	public void setSigla(String sigla) {
		
		this.sigla = sigla;
		
	}

	public String getNome_reduzido() {
		
		return nome_reduzido;
		
	}

	public void setNome_reduzido(String nome_reduzido) {
		
		this.nome_reduzido = nome_reduzido;
		
	}

}
