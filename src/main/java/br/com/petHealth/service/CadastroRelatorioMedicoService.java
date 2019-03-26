package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.RelatorioMedico;
import br.com.petHealth.repository.CadastroRelatorioMedicoRepository;


public class CadastroRelatorioMedicoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4733715075875694536L;



	@Inject
	private CadastroRelatorioMedicoRepository cadastroRelatorioMedicoRepository;

	public void inserir(RelatorioMedico relatorioMedico){
		cadastroRelatorioMedicoRepository.insert(relatorioMedico);

	}
	
	public List<Animal> findAll() {				
		return cadastroRelatorioMedicoRepository.findAll();
	}


}
