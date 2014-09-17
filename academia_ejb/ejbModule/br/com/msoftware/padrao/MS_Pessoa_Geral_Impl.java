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
@Entity @Table(name="PESSOA_0001")
@SequenceGenerator(name = "pessoa", sequenceName = "sequencia", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name="ID"))
public class MS_Pessoa_Geral_Impl extends MS_Classe_Padrao_Impl implements MS_Pessoa_Geral {

	@Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa")
	public Long getId(){
		
		return id;
		
	}
	
	public MS_Pessoa_Geral_Impl novoObjeto() {

		return new MS_Pessoa_Geral_Impl();
		
	}
	
}
