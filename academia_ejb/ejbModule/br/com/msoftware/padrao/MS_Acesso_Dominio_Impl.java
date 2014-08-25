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

import br.com.msoftware.padrao.MS_Acesso_Dominio;


@Stateless
@Entity @Table(name="SEGUR_0001")
@SequenceGenerator(name = "dominio", sequenceName = "sequencia", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name="ID"))
public class MS_Acesso_Dominio_Impl extends MS_Classe_Padrao_Impl implements MS_Acesso_Dominio {
	
	@Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dominio")
	public Long getId(){
		
		return id;
		
	}
	
	public MS_Acesso_Dominio_Impl novoObjeto() {

		return new MS_Acesso_Dominio_Impl();
		
	}

}
