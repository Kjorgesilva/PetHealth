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

import br.com.petHealth.json.response.EnderecoResponse;
import br.com.petHealth.model.Endereco;
import br.com.petHealth.service.EnderecoService;


@Path("/endereco")
public class EnderecoWs implements Serializable {
	
	@Inject
	private EnderecoService enderecoService;
	private List<Endereco> listaEndereco;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/listaEndereco")
	public List<EnderecoResponse> listaEndereco(){
	
		System.out.println("Chegou aqui endereco");
		listaEndereco = enderecoService.findAll();
		List<EnderecoResponse> list = new ArrayList<>();
		
		
		for (Endereco endereco : listaEndereco) {
			EnderecoResponse enderecoResponse = new EnderecoResponse();
			
			enderecoResponse.setId(endereco.getId());
			enderecoResponse.setRua(endereco.getRua());
			enderecoResponse.setEstado(endereco.getEstado());
			enderecoResponse.setCidade(endereco.getCidade());
			enderecoResponse.setBairro(endereco.getBairro());
			list.add(enderecoResponse);					
		}

		
		return list;
		
	}

	
	
	

}
