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

import br.com.petHealth.json.response.ClienteResponse;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.service.ClienteService;


@Path("/cliente")
public class ClienteWs implements Serializable {
	

	@Inject
	private ClienteService clienteService;
	private List<Cliente> listaCliente;
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/listaCliente")
	public List<ClienteResponse> listaCliente(){
		
		System.out.println("Chegou aqui no cliente!!!!!!!!!!!!");
		listaCliente = clienteService.findAll();
		List<ClienteResponse> list = new ArrayList<>();		
		
		for (Cliente cliente : listaCliente) {
			ClienteResponse clienteResponse = new ClienteResponse();
			
			clienteResponse.setId(cliente.getId());
			clienteResponse.setNome(cliente.getNome());
			clienteResponse.setRg(cliente.getRg());
			clienteResponse.setEmail(cliente.getEmail());
			clienteResponse.setEndereco(cliente.getEndereco());
			clienteResponse.setTelefone(cliente.getTelefone());
			clienteResponse.setIdUsuario(cliente.getUsuario().getId());
			
			list.add(clienteResponse);					
		}

		
		return list;
	}


	
	
}
