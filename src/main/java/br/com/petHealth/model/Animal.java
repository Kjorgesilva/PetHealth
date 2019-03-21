package br.com.petHealth.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tab_animal")
public class Animal implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_animal")
	private int id;	
	
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "raca")
	private String raca;
	
	@Column(name = "cor")
	private String cor;
	
	@Column(name = "data_de_nascimento")
	private LocalDateTime dataNascimento;
	
	@Column(name = "sexo")
	private char sexo;
	
	
	@Column(name = "pais_de_origem")
	private String paisOrigem;
	
	
	@Column(name = "observacoes")
	private String observacoes;


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
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
