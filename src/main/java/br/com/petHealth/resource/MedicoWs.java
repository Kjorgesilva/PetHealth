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
import br.com.petHealth.json.response.MedicoResponse;
import br.com.petHealth.json.response.VacinaResponse;
import br.com.petHealth.model.Medico;
import br.com.petHealth.service.CadastroMedicoService;


@Path("/medico")
public class MedicoWs implements Serializable {

	@Inject
	private CadastroMedicoService medicoService;
	private List<Medico> listaMedico;
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/listamedico")
	public List<MedicoResponse> listaMedico(){
		
		System.out.println("Chegou aqui no medico");
		listaMedico = medicoService.findAll();
		List<MedicoResponse> list = new ArrayList<>();
		
		
		for (Medico medico : listaMedico) {
			MedicoResponse medicoResponse = new MedicoResponse();
			
			medicoResponse.setId(medico.getId());
			medicoResponse.setNome(medico.getNome());
			medicoResponse.setTelefone(medico.getTelefone());
			medicoResponse.setEmail(medico.getEmail());
			medicoResponse.setTipoUsuario(medico.getUsuario().getId());
			
			list.add(medicoResponse);					
		}

		
		return list;
	}
	
	
	
}
