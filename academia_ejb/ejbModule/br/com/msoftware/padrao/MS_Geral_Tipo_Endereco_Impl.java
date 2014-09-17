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
@Entity @Table(name="PESSOA_0005")
@SequenceGenerator(name = "tipoendereco", sequenceName = "sequencia", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name="ID"))
public class MS_Geral_Tipo_Endereco_Impl  extends MS_Classe_Padrao_Impl implements MS_Geral_Tipo_Endereco {

	@Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoendereco")
	public Long getId(){

		if(this.id == null){
			
			this.setId(new Long(0));
			
		}
		
		return id;
		
	}
	
	public MS_Geral_Tipo_Endereco_Impl novoObjeto() {

		return new MS_Geral_Tipo_Endereco_Impl();
		
	}
	
}
