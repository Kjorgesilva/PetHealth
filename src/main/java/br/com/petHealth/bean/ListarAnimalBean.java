package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.service.CadastroAnimalService;
import br.com.petHealth.service.CadastroRelatorioMedicoService;


@Named
@ViewScoped
public class ListarAnimalBean implements Serializable{
	
	public void init(){
		listar();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6744500865487566617L;
	
	@Inject 
	private CadastroAnimalService animalService;
	private List<Animal> animal;
	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void listar(){		
		animal = animalService.findAll();
	}
	
		
	public CadastroAnimalService getAnimalService() {
		return animalService;
	}

	public void setAnimalService(CadastroAnimalService animalService) {
		this.animalService = animalService;
	}

	public List<Animal> getAnimal() {
		return animal;
	}
	public void setAnimal(List<Animal> animal) {
		this.animal = animal;
	}

}
