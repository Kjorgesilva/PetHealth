package br.com.petHealth.json.response;

import java.io.Serializable;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.TipoVacinas;

public class VacinaResponse implements Serializable{

	private int id;
	private String aviso;
	private String dataVacina;
	private String dataDaProxima;

	
	private String nomeVacina;
	private Integer idTipoVacina;
	
	private String nomeAnimal;
	private Integer idAnimal;



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAviso() {
		return aviso;
	}
	public void setAviso(String aviso) {
		this.aviso = aviso;
	}
	public String getDataVacina() {
		return dataVacina;
	}
	public void setDataVacina(String dataVacina) {
		this.dataVacina = dataVacina;
	}
	public String getDataDaProxima() {
		return dataDaProxima;
	}
	public void setDataDaProxima(String dataDaProxima) {
		this.dataDaProxima = dataDaProxima;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getNomeVacina() {
		return nomeVacina;
	}
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	public Integer getIdTipoVacina() {
		return idTipoVacina;
	}
	public void setIdTipoVacina(Integer idTipoVacina) {
		this.idTipoVacina = idTipoVacina;
	}
	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}


	


}
