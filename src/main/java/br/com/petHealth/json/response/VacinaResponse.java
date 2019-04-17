package br.com.petHealth.json.response;

import java.io.Serializable;

public class VacinaResponse implements Serializable{
	
	private int id;
    private String aviso;
    private String dataVacina;
    private String dataDaProxima;
    private String descricao;
    
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
    

}
