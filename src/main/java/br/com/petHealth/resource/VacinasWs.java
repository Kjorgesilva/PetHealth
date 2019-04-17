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

import br.com.petHealth.json.response.VacinaResponse;
import br.com.petHealth.model.Vacina;
import br.com.petHealth.service.VacinasAplicadasService;



@Path("/vacinacao")
public class VacinasWs implements Serializable {

	@Inject
	private VacinasAplicadasService vacinasService;
	private List<Vacina> listaVacinas;

		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/listavacinas")
	public List<VacinaResponse> listaVacinas() {
		System.out.println("Chegou");
		listaVacinas = vacinasService.findAll();
		List<VacinaResponse> list = new ArrayList<>();

		
		for(Vacina vacina : listaVacinas){
			VacinaResponse vacinaResponse = new VacinaResponse();

			vacinaResponse.setId(vacina.getId());
			vacinaResponse.setAviso(vacina.getAviso());
			vacinaResponse.setDataDaProxima("01/01/2001");
			vacinaResponse.setDataVacina("01/01/2001");
			
			list.add(vacinaResponse);
			
		}
		
		return list;
	}

}
