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
import javax.persistence.Transient;

@Entity
@Table(name="tab_vacina")
public class Vacinas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8819868273224222754L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vacina")
	private Integer id;
	
	@Column(name="aviso")
	private String aviso;
	
	@Column(name="data_vacina")
	private LocalDateTime dataVacina;
	
	@Column(name="data_da_proxima")
	private LocalDateTime dataProxima;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="vacina_em_dia")
	private boolean vacinaEmDia;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_animal")
	private Animal  animal ;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_vacina")
	private TipoVacinas  tipoVacina ;


	public boolean isVacinaEmDia() {
		return vacinaEmDia;
	}


	public void setVacinaEmDia(boolean vacinaEmDia) {
		this.vacinaEmDia = vacinaEmDia;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAviso() {
		return aviso;
	}


	public void setAviso(String aviso) {
		this.aviso = aviso;
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
