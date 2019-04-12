package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Vacina;
import br.com.petHealth.repository.VacinasAplicadasRepository;

public class VacinasAplicadasService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3797783424458112L;
	@Inject
	private VacinasAplicadasRepository aplicadasRepository;
	
	public List<Vacina> findAll(int id) {	
		return aplicadasRepository.findAll(id);
	}
}