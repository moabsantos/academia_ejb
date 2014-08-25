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
@Entity
@Table(name="SEGUR_0003")
@SequenceGenerator(name = "grupo", sequenceName = "sequencia", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name="ID"))
public class MS_Acesso_Grupo_Impl extends MS_Classe_Padrao_Impl implements MS_Acesso_Grupo  {
	
	@Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo")
	public Long getId(){
		
		return id;
		
	}
	
	@Override
	public MS_Acesso_Grupo_Impl novoObjeto() {

		return new MS_Acesso_Grupo_Impl();
		
	}

}
