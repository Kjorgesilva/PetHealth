package br.com.petHealth.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.petHealth.json.response.AnimalResponse;
import br.com.petHealth.model.Animal;
import br.com.petHealth.service.CadastroAnimalService;

@Path("/animal")
public class AnimalWs implements Serializable{
	
	@Inject
	private CadastroAnimalService animalService;
	private List<Animal> listaAnimal;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/listaanimal")
	public List<AnimalResponse> listAnimal(){
		
		System.out.println("Chegou aqui animal ");
		listaAnimal = animalService.findAll();
		List<AnimalResponse> list = new ArrayList<>();
		
		
		for (Animal animal : listaAnimal) {
			AnimalResponse animalResponse = new AnimalResponse();
			
//			private String dataNascimento;
//			private String sexo;
//			private String paisDeOrigem;
//			private String observacoes;
//			private Integer idCliente;
//			private Integer idEspecie;
			
			animalResponse.setId(animal.getId());
			animalResponse.setNome(animal.getNome());
			animalResponse.setRaca(animal.getRaca());
			animalResponse.setCor(animal.getCor());
			animalResponse.setSexo(animal.getSexo());
			animalResponse.setObservacoes(animal.getObservacoes());
			animalResponse.setPaisDeOrigem(animal.getPaisOrigem());
			animalResponse.setIdCliente(animal.getCliente().getId());
			animalResponse.setDataNascimento(animal.getDataNascimento().toString());
			animalResponse.setIdEspecie(animal.getIdEspecieAnimal().getId());
			
			list.add(animalResponse);					
		}

		
		return list;	
	
	
	}
	

}
