package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.model.RelatorioMedico;
import br.com.petHealth.service.CadastroRelatorioMedicoService;

@Named
@ViewScoped
public class CadastroRelatorioMedicoBean implements Serializable {


	public void init(){
		listar();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2544796501440233453L;


	@Inject 
	private CadastroRelatorioMedicoService cadastroRelatorioMedicoService;
	private List<Animal> animal;
	

	public void listar(){		
		animal = cadastroRelatorioMedicoService.findAll();
	}
	
	public CadastroRelatorioMedicoService getCadastroRelatorioMedicoService() {
		return cadastroRelatorioMedicoService;
	}
	public void setCadastroRelatorioMedicoService(CadastroRelatorioMedicoService cadastroRelatorioMedicoService) {
		this.cadastroRelatorioMedicoService = cadastroRelatorioMedicoService;
	}
	
	public List<Animal> getAnimal() {
		return animal;
	}
	public void setAnimal(List<Animal> animal) {
		this.animal = animal;
	}


}
