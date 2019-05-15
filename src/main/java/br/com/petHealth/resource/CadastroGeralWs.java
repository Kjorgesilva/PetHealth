package br.com.petHealth.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.petHealth.json.response.AnimalResponse;
import br.com.petHealth.json.response.CadastroGeral;
import br.com.petHealth.json.response.EnderecoResponse;
import br.com.petHealth.json.response.MedicoResponse;
import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Endereco;
import br.com.petHealth.model.Medico;
import br.com.petHealth.service.AnimalService;
import br.com.petHealth.service.EnderecoService;
import br.com.petHealth.service.MedicoService;

@Path("/cadastro")
public class CadastroGeralWs implements Serializable{
	
	@Inject
	private AnimalService animalService;	
	private List<Animal> listaAnimal;
	
	
	@Inject
	private EnderecoService enderecoService;
	private List<Endereco> listaEndereco;
	
	
	@Inject
	private MedicoService medicoService;
	private List<Medico> listaMedico;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{idCliente}/listaCadastroGeral")
	public CadastroGeral listGeral (@PathParam("idCliente") Integer id){
		
		CadastroGeral cadastroGeral = new CadastroGeral();

		listaAnimal = animalService.findByidCliente(id);
		
		List<AnimalResponse> list = new ArrayList<>();		
		for (Animal animal : listaAnimal) {
			AnimalResponse animalResponse = new AnimalResponse();			
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
		

		listaMedico = medicoService.findAll();
		List<MedicoResponse> listMedico = new ArrayList<>();
		
		
		for (Medico medico : listaMedico) {
			MedicoResponse medicoResponse = new MedicoResponse();
			
			medicoResponse.setId(medico.getId());
			medicoResponse.setNome(medico.getNome());
			medicoResponse.setTelefone(medico.getTelefone());
			medicoResponse.setEmail(medico.getEmail());
			medicoResponse.setTipoUsuario(medico.getUsuario().getId());
			
			listMedico.add(medicoResponse);					
		}
		
		listaEndereco = enderecoService.findAll();
		List<EnderecoResponse> listEndereco = new ArrayList<>();
		
		
		for (Endereco endereco : listaEndereco) {
			EnderecoResponse enderecoResponse = new EnderecoResponse();
			
			enderecoResponse.setId(endereco.getId());
			enderecoResponse.setRua(endereco.getRua());
			enderecoResponse.setEstado(endereco.getEstado());
			enderecoResponse.setCidade(endereco.getCidade());
			enderecoResponse.setBairro(endereco.getBairro());
			listEndereco.add(enderecoResponse);					
		}
		
		
		
		cadastroGeral.setListaAnimal(list);
		cadastroGeral.setListaEndereco(listEndereco);
		cadastroGeral.setListaMedico(listMedico);
		
		
		
		
		

		return cadastroGeral;	
	}

	

}
