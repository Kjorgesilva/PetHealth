package br.com.petHealth.resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.petHealth.json.response.RelatorioResponse;
import br.com.petHealth.model.RespostaRelatorio;
import br.com.petHealth.service.RelatorioMedicoService;


@Path("/relatorio")
public class RelatorioWs {

	
	@Inject
	private RelatorioMedicoService relatorioService;
	private List<RespostaRelatorio> listaRelatorio;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/listaRelatorio")
public List<RelatorioResponse> listaRelatorio(){
		
		System.out.println("Chegou relatorio");
		listaRelatorio = relatorioService.findAllResposta();
		List<RelatorioResponse> list = new ArrayList<>();
		
		for (RelatorioResponse relatorios : list) {
			
			RelatorioResponse relatorio = new RelatorioResponse();
			
			relatorio.setId(relatorio.getId());
		
			list.add(relatorio);					
		}

		
		return list;
	}
	
	
	
}
