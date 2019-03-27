package br.com.petHealth.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.service.CadastroAnimalService;

@Named
@ViewScoped
public class CadastroAnimalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1566842690014543106L;

	@Inject
	private CadastroAnimalService cadastroAnimalService;
	private Animal animal;
	private int id;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@PostConstruct
	public void init(){

		if(id>0){
			animal = cadastroAnimalService.findByid(id);
		}else{
			Cliente c = new Cliente();
			animal = new Animal();
			animal.setCliente(c);
		}}


	public CadastroAnimalService getCadastroAnimalService() {
		return cadastroAnimalService;
	}


	public void setCadastroAnimalService(CadastroAnimalService cadastroAnimalService) {
		this.cadastroAnimalService = cadastroAnimalService;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public void inserir() {
		cadastroAnimalService.inserirAnimal(animal);

	}
	
public void salvar() {		
		if(animal.getId() != null && animal.getId() > 0){
			cadastroAnimalService.atualizar(animal);
		}else {
			cadastroAnimalService.inserirAnimal(animal);
		}
		
	}




}
