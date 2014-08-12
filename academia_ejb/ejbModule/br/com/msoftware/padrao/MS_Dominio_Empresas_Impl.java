package br.com.msoftware.padrao;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import br.com.msoftware.padrao.MS_Dominio_Empresas;


@Stateless
@Entity @Table(name="SEGUR_0002")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MS_Dominio_Empresas_Impl extends MS_Classe_Padrao implements MS_Dominio_Empresas {

	public MS_Dominio_Empresas_Impl(){
		
	}

	public MS_Dominio_Empresas_Impl novoObjeto() {

		return new MS_Dominio_Empresas_Impl();
		
	}

}
