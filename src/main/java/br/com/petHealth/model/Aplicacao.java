package br.com.petHealth.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tab_aplicacao database table.
 * 
 */
@Entity
@Table(name="tab_aplicacao")
public class Aplicacao implements Serializable {

	private static final long serialVersionUID = -2266959882310193578L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aplicacao")
	private int idAplicacao;

	@Column(name="caminho_aplicacao")
	private String caminhoAplicacao;

	@Column(name="menu_aplicacao")
	private String menuAplicacao;

	@Column(name="nome_aplicacao")
	private String nomeAplicacao;
	
	@Column(name="exibe_menu_aplicacao")
	private String exibeMenu;

	public Aplicacao() {
	}

	public String getCaminhoAplicacao() {
		return this.caminhoAplicacao;
	}

	public void setCaminhoAplicacao(String caminhoAplicacao) {
		this.caminhoAplicacao = caminhoAplicacao;
	}

	public int getIdAplicacao() {
		return this.idAplicacao;
	}

	public void setIdAplicacao(int idAplicacao) {
		this.idAplicacao = idAplicacao;
	}

	public String getMenuAplicacao() {
		return this.menuAplicacao;
	}

	public void setMenuAplicacao(String menuAplicacao) {
		this.menuAplicacao = menuAplicacao;
	}

	public String getNomeAplicacao() {
		return this.nomeAplicacao;
	}

	public void setNomeAplicacao(String nomeAplicacao) {
		this.nomeAplicacao = nomeAplicacao;
	}

	public String getExibeMenu() {
		return exibeMenu;
	}

	public void setExibeMenu(String exibeMenu) {
		this.exibeMenu = exibeMenu;
	}
	
	

}