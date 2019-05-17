package br.com.petHealth.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tab_perfil database table.
 * 
 */
@Entity
@Table(name="tab_perfil")
public class Perfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1622761037890456951L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil")
	private int id;

	private String descricao;


	public Perfil() {
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPerfil() {
		return this.id;
	}

	public void setId(int id) {
		this.id= id;
	}

}