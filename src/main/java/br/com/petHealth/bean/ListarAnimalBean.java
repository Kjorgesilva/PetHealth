package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.service.AnimalService;


@Named
@ViewScoped
public class ListarAnimalBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6744500865487566617L;
	
	@Inject 
	private AnimalService animalService;
	private List<Animal> animal;
	private int id;
	
	public void init(){
		listar();
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void listar(){		
		animal = animalService.findAll();
	}
	
	public AnimalService getAnimalService() {
		return animalService;
	}

	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	public List<Animal> getAnimal() {
		return animal;
	}
	public void setAnimal(List<Animal> animal) {
		this.animal = animal;
	}

}
