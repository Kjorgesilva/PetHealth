package br.com.petHealth.resource;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONObject;

import br.com.petHealth.model.Agendamento;
import br.com.petHealth.service.AgendamentoService;


@Path("/consulta")
public class ConsultaMedicaWs implements Serializable{
	
	
	@Inject
	private AgendamentoService agendamentoService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Agendamento getTestService(String json) {
		JSONObject jsonObject = new JSONObject(json);
		Agendamento agendamento = new Agendamento();
		System.out.println(json);
//		agendamento =  usuarioService.checkLogin(jsonObject.getString("login"),jsonObject.getString("senha")); 
		return agendamento;
	}

	
	
}
