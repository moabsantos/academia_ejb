package br.com.msoftware.academia;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.msoftware.academia.MS_Academia_Aluno;
import br.com.msoftware.padrao.MS_Classe_Padrao_Impl;
import br.com.msoftware.padrao.MS_Pessoa_Geral_Impl;

@Stateless
@Entity @Table(name="ACADEMIA_0001")
@SequenceGenerator(name = "aluno", sequenceName = "sequencia", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name="ID"))
public class MS_Academia_Aluno_Impl extends MS_Classe_Padrao_Impl implements MS_Academia_Aluno {

	@OneToOne(cascade=CascadeType.ALL)
	protected MS_Pessoa_Geral_Impl pessoa;
	
	@OneToMany(mappedBy = "aluno")
	protected List<MS_Academia_Modalidade_Impl> modalidade;
	
	@Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	public Long getId(){
		
		return id;
		
	}
	
	public MS_Academia_Aluno_Impl novoObjeto() {

		return new MS_Academia_Aluno_Impl();
		
	}
	
	public MS_Pessoa_Geral_Impl getPessoa(){
		return this.pessoa;
	}
	
	public void setPessoa(MS_Pessoa_Geral_Impl pessoa){
		this.pessoa = pessoa;
	}
	
}
