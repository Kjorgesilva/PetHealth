package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Medico;
import br.com.petHealth.service.CadastroMedicoService;

@Named
@ViewScoped
public class ListarMedicoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5381732162580363523L;

	public void init(){
		listar();
	}

	@Inject 
	private CadastroMedicoService cadastroMedicoService;
	private List<Medico> medico;


	public void listar(){		
		medico = cadastroMedicoService.findAll();

	}	

	public CadastroMedicoService getCadastroMedicoService() {
		return cadastroMedicoService;
	}


	public void setCadastroMedicoService(CadastroMedicoService cadastroMedicoService) {
		this.cadastroMedicoService = cadastroMedicoService;
	}


	public List<Medico> getMedico() {
		return medico;
	}


	public void setMedico(List<Medico> medico) {
		this.medico = medico;
	}


}
