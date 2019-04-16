package br.com.petHealth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tab_tipo_vacina")
public class TipoVacinas implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2411357278602183001L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_vacina")
	private int id;
	
	
	@Column(name="descricao")
	private String descricao;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_especie")
	private EspecieAnimal especie;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
