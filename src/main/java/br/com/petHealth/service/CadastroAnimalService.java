package br.com.petHealth.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.petHealth.model.Animal;
import br.com.petHealth.repository.CadastroAnimalRepository;

public class CadastroAnimalService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6097645191515785881L;
	
	@Inject
	private CadastroAnimalRepository cadastroAnimalRepository;
	
	
	public void inserirAnimal(Animal animal){ 		
		cadastroAnimalRepository.insert(animal);		
	}
	
	public Animal findByid(int id){
		cadastroAnimalRepository = new CadastroAnimalRepository();
		return cadastroAnimalRepository.findByid(id);
	}
	
	public Animal atualizar(Animal animal){		
		return animal = cadastroAnimalRepository.atualizar(animal);
	}

}
