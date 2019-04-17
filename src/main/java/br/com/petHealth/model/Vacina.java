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
@Table(name = "tab_vacina_tomada")
public class Vacina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3325047940834255081L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vacina_tomada_especie")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "animal_id")
	private Animal idAnimal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vacina_id")
	private TipoVacinas  tipoVacina ;

	@Column(name = "data_vacina")
	private LocalDateTime dataVacina;

	@Column(name = "data_da_proxima")
	private LocalDateTime dataProxima;

	@Column(name = "aviso")
	private String aviso;

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

	public String getAviso() {
		return aviso;
	}

	public void setAviso(String aviso) {
		this.aviso = aviso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Animal getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Animal idAnimal) {
		this.idAnimal = idAnimal;
	}

	public TipoVacinas getTipoVacina() {
		return tipoVacina;
	}

	public void setTipoVacina(TipoVacinas tipoVacina) {
		this.tipoVacina = tipoVacina;
	}



}
