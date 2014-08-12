package br.com.msoftware.padrao;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.Table;

@Stateless
@Entity
@Table(name="SEGUR_0003")
public class MS_Grupo_Empresas_Impl extends MS_Classe_Padrao implements MS_Grupo_Empresas  {
	
	@Override
	public MS_Grupo_Empresas_Impl novoObjeto() {

		return new MS_Grupo_Empresas_Impl();
		
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
