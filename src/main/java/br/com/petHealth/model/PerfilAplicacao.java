package br.com.petHealth.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the tab_perfil_aplicacao database table.
 * 
 */
@Entity
@Table(name="tab_perfil_aplicacao")
public class PerfilAplicacao implements Serializable {

	private static final long serialVersionUID = -28247316211724484L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil_aplicacao", columnDefinition = "bigint(20,0)")
	private BigInteger idPerfilAplicacao;

	@ManyToOne
	@JoinColumn(name="aplicacao_id")
	private Aplicacao aplicacao;

	@ManyToOne
	@JoinColumn(name="perfil_id")
	private Perfil perfil;

	public PerfilAplicacao() {
	}

	public BigInteger getIdPerfilAplicacao() {
		return this.idPerfilAplicacao;
	}

	public void setIdPerfilAplicacao(BigInteger idPerfilAplicacao) {
		this.idPerfilAplicacao = idPerfilAplicacao;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	

}