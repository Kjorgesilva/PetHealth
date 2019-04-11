package br.com.petHealth.model;

import java.io.Serializable;

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
@Table(name="tab_vacina_especie")
public class VacinaEspecie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 667598996012982176L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vacina_especie")
	private int id;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_especie")
	private EspecieAnimal  vacinaEspecie ;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_vacina_especie")
	private TipoVacinas  tipoVacina ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EspecieAnimal getVacinaEspecie() {
		return vacinaEspecie;
	}

	public void setVacinaEspecie(EspecieAnimal vacinaEspecie) {
		this.vacinaEspecie = vacinaEspecie;
	}

	public TipoVacinas getTipoVacina() {
		return tipoVacina;
	}

	public void setTipoVacina(TipoVacinas tipoVacina) {
		this.tipoVacina = tipoVacina;
	}
	
	


}
