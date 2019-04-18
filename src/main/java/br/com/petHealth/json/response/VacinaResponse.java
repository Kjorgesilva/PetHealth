package br.com.petHealth.json.response;

import java.io.Serializable;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.TipoVacinas;

public class VacinaResponse implements Serializable{

	private int id;
	private String aviso;
	private String dataVacina;
	private String dataDaProxima;
	private Animal idAnimal;
	private TipoVacinas idTipoVacina;



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
	public Animal getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(Animal idAnimal) {
		this.idAnimal = idAnimal;
	}
	public TipoVacinas getIdTipoVacina() {
		return idTipoVacina;
	}
	public void setIdTipoVacina(TipoVacinas idTipoVacina) {
		this.idTipoVacina = idTipoVacina;
	}




}
