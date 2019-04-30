package br.com.petHealth.resource;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.primefaces.json.JSONObject;
import br.com.petHealth.model.Agendamento;
import br.com.petHealth.repository.ClienteRepository;
import br.com.petHealth.service.AgendamentoService;
import br.com.petHealth.service.AnimalService;
import br.com.petHealth.service.ClienteService;
import br.com.petHealth.service.MedicoService;
import br.com.petHealth.service.EnderecoService;

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
	public Agendamento getTestService(String json) {
		JSONObject jsonObject = new JSONObject(json);
		Agendamento agendamento = new Agendamento();
		System.out.println(json);		
		
		agendamento.setId(jsonObject.getInt("id"));
		
		int idCliente = jsonObject.getInt("id_cliente");
		agendamento.setCliente(clienteService.findByid(idCliente));//		
		
		int idAnimal = jsonObject.getInt("id_animal");
		agendamento.setAnimal(animalService.findByid(idAnimal));	
	
		int idMedico = jsonObject.getInt("id_medico");
		agendamento.setMedico(medicoService.findById(idMedico));
		
		int idEndereco = jsonObject.getInt("id_endereco");
		agendamento.setEndereco(enderecoService.findByid(idEndereco));
	
		
//		agendamento.setCliente(jsonObject.getString("nomeDono"));
//		agendamento.setEndereco(jsonObject.getString("endereco"));
//		agendamento.setDataInicio(jsonObject.getString("data"));
//		agendamento.setDataFim(jsonObject.getString("dataFim"));
//		agendamento.setAnimal(jsonObject.getString("nome"));
//		agendamento.setMedico(jsonObject.getString("spinnerMedico"));		

		agendamentoService.insert(agendamento);
		return agendamento;
	}

}
