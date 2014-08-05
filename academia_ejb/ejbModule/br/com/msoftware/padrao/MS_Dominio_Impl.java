package br.com.msoftware.padrao;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.msoftware.db.DataSetImpl;
import br.com.msoftware.padrao.MS_Dominio;


@Stateless
@Entity
@Table(name="SEGUR_0002")
public class MS_Dominio_Impl extends DataSetImpl implements MS_Dominio {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String observacao;	

	public Long getId(){
		
		return this.id;
		
	}
	
	public String getNome() {
		return nome;
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
	public void atualizar(String p_nome, String p_observacao) {
		
		this.setNome(p_nome);
		this.setObservacao(p_observacao);
		
	}

	public MS_Dominio_Impl novoObjeto() {

		return new MS_Dominio_Impl();
		
	}

}
