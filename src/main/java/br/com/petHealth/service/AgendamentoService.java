package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Agendamento;
import br.com.petHealth.repository.AgendamentoRepository;

public class AgendamentoService implements Serializable {

	@Inject
	private AgendamentoRepository agendamentoRepository;

	public void insert(Agendamento agendamento) {
		agendamentoRepository.insert(agendamento);
	}

	public List<Agendamento> findAll() {
		return agendamentoRepository.findAll();
	}

	public Agendamento findByid(int id) {
		return agendamentoRepository.findByid(id);
	}

	public int update(int agenda) {
		return agendamentoRepository.update(agenda);
	}

}
