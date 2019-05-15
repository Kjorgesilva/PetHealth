package br.com.petHealth.resource;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	@Path("{idCliente}/listaVacinas")
	public List<VacinaResponse> listaVacinas(@PathParam("idCliente") Integer id) {
		
		System.out.println("Chegou");
		listaVacinas = vacinasService.findAllCliente(id);
		List<VacinaResponse> list = new ArrayList<>();

		
		for(Vacina vacina : listaVacinas){
			VacinaResponse vacinaResponse = new VacinaResponse();

//			vacinaResponse.setDataDaProxima(hoje);
//			vacinaResponse.setDataVacina(hoje.plusMonths(2));
			
			LocalDate localDate = LocalDate.now(); 
	        LocalDate localDate2 = LocalDate.now(); 

	        java.sql.Date date = java.sql.Date.valueOf(localDate);
	        java.sql.Date dateee = java.sql.Date.valueOf(localDate2.plusMonths(2));
	        localDate2.plusMonths(2);
	        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	        String dataFormatada = formatador.format(date);
	        String dataProxima = formatador.format(dateee);

			vacinaResponse.setId(vacina.getId());
			vacinaResponse.setAviso(vacina.getAviso());			
		
			vacinaResponse.setDataVacina(dataFormatada);
			vacinaResponse.setDataDaProxima(dataProxima);

			
			vacinaResponse.setNomeAnimal(vacina.getIdAnimal().getNome());
			vacinaResponse.setIdAnimal(vacina.getIdAnimal().getId());
			
			vacinaResponse.setNomeVacina(vacina.getTipoVacina().getDescricao());
			vacinaResponse.setIdTipoVacina(vacina.getTipoVacina().getId());
			
			
			list.add(vacinaResponse);
			System.out.println(vacina.getIdAnimal().getNome());
			
			
			
		}
		
		return list;
	}

}
