package br.com.msoftware.academia;

import br.com.msoftware.padrao.MS_Classe_Padrao_Impl_;
import br.com.msoftware.padrao.MS_Pessoa_Geral_Impl;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-09-16T07:01:54.701-0300")
@StaticMetamodel(MS_Academia_Aluno_Impl.class)
public class MS_Academia_Aluno_Impl_ extends MS_Classe_Padrao_Impl_ {
	public static volatile SingularAttribute<MS_Academia_Aluno_Impl, Long> id;
	public static volatile SingularAttribute<MS_Academia_Aluno_Impl, MS_Pessoa_Geral_Impl> pessoa;
	public static volatile ListAttribute<MS_Academia_Aluno_Impl, MS_Academia_Modalidade_Impl> modalidade;
}
