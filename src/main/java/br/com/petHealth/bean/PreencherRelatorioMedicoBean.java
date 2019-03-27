package br.com.petHealth.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PreencherRelatorioMedicoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5152385735575093007L;
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
