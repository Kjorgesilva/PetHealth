package br.com.petHealth.bean;

import java.awt.Checkbox;
import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Vacinas;
import br.com.petHealth.service.VacinasService;

@Named
@ViewScoped
public class VacinasBean implements Serializable {

	public void init(){
		listar();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6792217703193989153L;
	
	@Inject
	private VacinasService vacinasService;
	
	private List<Vacinas> vacinas;
	
	
	public void listar(){
		vacinas = vacinasService.findAll();		
	}

	public VacinasService getVacinasService() {
		return vacinasService;
	}

	public void setVacinasService(VacinasService vacinasService) {
		this.vacinasService = vacinasService;
	}

	public List<Vacinas> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<Vacinas> vacinas) {
		this.vacinas = vacinas;
	}
	

}
