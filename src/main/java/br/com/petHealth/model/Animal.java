package br.com.petHealth.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="tab_animal")
public class Animal implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6831023856379953558L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_animal")
	private Integer id;	
	
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "raca")
	private String raca;
	
	@Column(name = "cor")
	private String cor;
	
	@Column(name = "data_de_nascimento")
	private LocalDateTime dataNascimento;
	
	@Column(name = "sexo")
	private String sexo;
	
	
	@Column(name = "pais_de_origem")
	private String paisOrigem;
	
	
	@Column(name = "observacoes")
	private String observacoes;
	

	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;



	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getRaca() {
		return raca;
	}


	public void setRaca(String raca) {
		this.raca = raca;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getPaisOrigem() {
		return paisOrigem;
	}


	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}


	public String getObservacoes() {
		return observacoes;
	}


	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}





	
}
