package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Vacinas;
import br.com.petHealth.repository.VacinasRepository;

public class VacinasService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 955316697540746832L;
	
	@Inject
	private VacinasRepository vacinasRepository;
	
	public List<Vacinas> findAll() {
		return vacinasRepository.findAll();
		
		}
	

}
