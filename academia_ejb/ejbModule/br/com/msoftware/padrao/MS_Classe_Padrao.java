package br.com.msoftware.padrao;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.msoftware.db.DataSetImpl;

@MappedSuperclass
abstract class MS_Classe_Padrao extends DataSetImpl {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	protected String nome;
	protected String observacao;
	
	protected int flag_ativo;
	protected int flag_cadastro;
	protected int flag_excluido;
	
	public MS_Classe_Padrao(){
		
	}
	
	public int getFlag_ativo() {
		
		return flag_ativo;
		
	}

	public void setFlag_ativo(int flag_ativo) {
		
		this.flag_ativo = flag_ativo;
		
	}

	public int getFlag_cadastro() {
		
		return flag_cadastro;
		
	}

	public void setFlag_cadastro(int flag_cadastro) {
		
		this.flag_cadastro = flag_cadastro;
		
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

}
