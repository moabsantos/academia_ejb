package br.com.msoftware.academia;

import javax.ejb.Stateless;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.msoftware.padrao.MS_Classe_Padrao_Impl;

@Stateless
@Entity @Table(name="ACADEMIA_0002")
@SequenceGenerator(name = "modalidade", sequenceName = "sequencia", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name="ID"))
public class MS_Academia_Modalidade_Impl extends MS_Classe_Padrao_Impl implements MS_Academia_Modalidade {
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	protected MS_Academia_Aluno_Impl aluno;
	
	@Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modalidade")
	public Long getId(){
		
		return id;
		
	}
	
	public MS_Academia_Modalidade_Impl novoObjeto() {

		return new MS_Academia_Modalidade_Impl();
		
	}
	
	public MS_Academia_Aluno_Impl getAluno(){
		
		return this.aluno;
	}
	
	public void setAluno(MS_Academia_Aluno_Impl aluno){
		
		this.aluno = aluno;
		
	}
	
}
