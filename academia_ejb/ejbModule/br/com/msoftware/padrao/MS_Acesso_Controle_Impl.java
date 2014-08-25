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

import br.com.msoftware.padrao.MS_Acesso_Controle;

@Stateless
@Entity @Table(name="SEGUR_0006")
@SequenceGenerator(name = "acesso", sequenceName = "sequencia", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name="ID"))
public class MS_Acesso_Controle_Impl extends MS_Classe_Padrao_Impl implements MS_Acesso_Controle {

	private String ip_acesso;
	private String id_sessao;

	@Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acesso")
	public Long getId(){
		
		return id;
		
	}
	
	public MS_Acesso_Controle salvaLogin(MS_Acesso_Controle p_usuario) throws Exception{
		
		return (MS_Acesso_Controle) super.salvar(p_usuario);
		
	}
	
	public MS_Acesso_Controle_Impl novoObjeto() {
		
		return new MS_Acesso_Controle_Impl();
		
	}

	@Override
	public MS_Acesso_Controle_Impl setDadosConexao(String p_cod_ip, String p_id_sessao, MS_Acesso_Controle p_usuario) throws Exception {
		
		((MS_Acesso_Controle_Impl) p_usuario).setIp_acesso(p_cod_ip);
		((MS_Acesso_Controle_Impl) p_usuario).setId_sessao(p_id_sessao);;

		return (MS_Acesso_Controle_Impl) super.salvar(p_usuario, p_usuario);
				
	}

	@Override
	public boolean validaDadosConexao(String p_cod_ip, String p_id_sessao) {
		
		return (p_cod_ip.equals(this.getIp_acesso())) && (p_id_sessao.equals(this.getId_sessao()));
		
	};
	
	public String getIp_acesso() {
		
		return ip_acesso;
	
	}

	public void setIp_acesso(String ip_acesso) {
	
		this.ip_acesso = ip_acesso;
	
	}

	public String getId_sessao() {
	
		return id_sessao;
	
	}

	public void setId_sessao(String id_sessao) {
	
		this.id_sessao = id_sessao;
	
	}
	
}
