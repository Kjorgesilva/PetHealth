package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Agendamento;
import br.com.petHealth.service.AgendamentoService;

@Named
@ViewScoped
public class CadastroRelatorioMedicoBean implements Serializable {


	public void init(){
		listar();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2544796501440233453L;
	
	@Inject 
	private AgendamentoService agendamentoService;	
	private List<Agendamento> agenda;
	

	public void listar(){		
		agenda = agendamentoService.findAll();
	}


	public AgendamentoService getAgendamentoService() {
		return agendamentoService;
	}


	public void setAgendamentoService(AgendamentoService agendamentoService) {
		this.agendamentoService = agendamentoService;
	}


	public List<Agendamento> getAgenda() {
		return agenda;
	}


	public void setAgenda(List<Agendamento> agenda) {
		this.agenda = agenda;
	}

}
