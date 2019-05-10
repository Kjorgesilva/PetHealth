package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Animal;
import br.com.petHealth.repository.AnimalRepository;

public class AnimalService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6097645191515785881L;
	
	@Inject
	private AnimalRepository cadastroAnimalRepository;
	
	
	public void inserirAnimal(Animal animal){ 		
		cadastroAnimalRepository.insert(animal);		
	}
	
	public Animal findByid(int id){
		cadastroAnimalRepository = new AnimalRepository();
		return cadastroAnimalRepository.findByid(id);
	}
	
	public Animal atualizar(Animal animal){		
		return animal = cadastroAnimalRepository.atualizar(animal);
	}
	public List<Animal> findAll() {		
		return cadastroAnimalRepository.findAll();
		
	}
	
	public List<Animal> findByidCliente(int id){
	return cadastroAnimalRepository.findByidCliente(id);
	}

}
