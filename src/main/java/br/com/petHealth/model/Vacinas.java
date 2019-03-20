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
import javax.persistence.Table;

@Entity
@Table(name="tab_vacina")
public class Vacinas implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vacina")
	private int id;
	
	@Column(name="resposta")
	private String resposta;
	
	@Column(name="data_vacina")
	private LocalDateTime dataVacina;
	
	@Column(name="data_da_proxima")
	private LocalDateTime dataProxima;
	
	@Column(name="descricao")
	private String descricao;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_animal")
	private Animal  animal ;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_vacina")
	private TipoVacinas  tipoVacina ;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getResposta() {
		return resposta;
	}


	public void setResposta(String resposta) {
		this.resposta = resposta;
	}


	public LocalDateTime getDataVacina() {
		return dataVacina;
	}


	public void setDataVacina(LocalDateTime dataVacina) {
		this.dataVacina = dataVacina;
	}


	public LocalDateTime getDataProxima() {
		return dataProxima;
	}


	public void setDataProxima(LocalDateTime dataProxima) {
		this.dataProxima = dataProxima;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public TipoVacinas getTipoVacina() {
		return tipoVacina;
	}


	public void setTipoVacina(TipoVacinas tipoVacina) {
		this.tipoVacina = tipoVacina;
	}



}
