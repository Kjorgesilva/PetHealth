package br.com.petHealth.resource;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.primefaces.json.JSONObject;

import br.com.petHealth.model.Agendamento;
import br.com.petHealth.service.AgendamentoService;
import br.com.petHealth.service.AnimalService;
import br.com.petHealth.service.ClienteService;
import br.com.petHealth.service.EnderecoService;
import br.com.petHealth.service.MedicoService;

@Path("/consulta")
public class ConsultaMedicaWs implements Serializable {

	@Inject
	private AgendamentoService agendamentoService;	
	@Inject
	private ClienteService clienteService;	
	@Inject
	private AnimalService animalService;	
	@Inject
	private MedicoService medicoService;	
	@Inject
	private EnderecoService enderecoService;


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTestService(String json) {
		JSONObject jsonObject = new JSONObject(json);
		Agendamento agendamento = new Agendamento();
		System.out.println(json);		
		

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime dataInicio = LocalDateTime.parse(jsonObject.getString("data"), formatter);
		LocalDateTime dataFim = LocalDateTime.parse(jsonObject.getString("dataFim"), formatter);
		
		agendamento.setDataInicio(dataInicio);		
		agendamento.setDataFim(dataFim);

		int idCliente = jsonObject.getInt("id_cliente");
		System.out.println( " idCliente: " + idCliente);
		agendamento.setCliente(clienteService.findByid(idCliente));//		
		
		int idAnimal = jsonObject.getInt("id_animal");
		agendamento.setAnimal(animalService.findByid(idAnimal));	
	
		int idMedico = jsonObject.getInt("id_medico");
		agendamento.setMedico(medicoService.findById(idMedico));
		
		int idEndereco = jsonObject.getInt("id_endereco");
		agendamento.setEndereco(enderecoService.findByid(idEndereco));
		
		agendamento.setStatus("P");

		agendamentoService.insert(agendamento);
		return Response.ok(json.toString()).build();
	}
	
	@POST
	@Path("/atualizaAgenda")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(String json) {		
		
		JSONObject jsonObject = new JSONObject(json);
		int idAgenda = jsonObject.getInt("id");
		System.out.println( " idAgenda: " + idAgenda);		
		agendamentoService.update(idAgenda);
		
		return Response.ok(json.toString()).build();
	}



	
	
	
}
