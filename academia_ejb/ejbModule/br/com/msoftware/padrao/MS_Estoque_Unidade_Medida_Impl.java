package br.com.msoftware.padrao;

import javax.ejb.Stateless;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Stateless
@Entity @Table(name="ESTOQ_0001")
@SequenceGenerator(name = "unidademedida", sequenceName = "sequencia", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name="ID"))
public class MS_Estoque_Unidade_Medida_Impl extends MS_Classe_Padrao_Impl implements MS_Estoque_Unidade_Medida {

	private Long idOrigem;
	private double fatorConversao;
	
	@Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidademedida")
	public Long getId(){
		return id;
	}
	
	public MS_Acesso_Dominio_Impl novoObjeto() {
		return new MS_Acesso_Dominio_Impl();
	}

	public Long getIdOrigem() {
		return idOrigem;
	}

	public void setIdOrigem(Long idOrigem) {
		this.idOrigem = idOrigem;
	}

	public double getFatorConversao() {
		return fatorConversao;
	}

	public void setFatorConversao(Long fatorConversao) {
		this.fatorConversao = fatorConversao;
	}

}
