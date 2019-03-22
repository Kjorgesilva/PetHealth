package br.com.petHealth.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Medico;
import br.com.petHealth.service.CadastroMedicoService;


@Named
@ViewScoped
public class CadastroMedicoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4373569129906307340L;
	
	
	@Inject
	private CadastroMedicoService cadastroMedicoService;
	private Medico medico;
	
	@PostConstruct
	public void init(){
		medico = new Medico();
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public CadastroMedicoService getCadastroMedicoService() {
		return cadastroMedicoService;
	}

	public void setCadastroMedicoService(CadastroMedicoService cadastroMedicoService) {
		this.cadastroMedicoService = cadastroMedicoService;
	}
	
	public void inserir() {
		cadastroMedicoService.insert(medico);
	}

}
