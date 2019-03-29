package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.PerguntaRelatorio;
import br.com.petHealth.model.RespostaRelatorio;
import br.com.petHealth.repository.CadastroRelatorioMedicoRepository;


public class CadastroRelatorioMedicoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4733715075875694536L;



	@Inject
	private CadastroRelatorioMedicoRepository cadastroRelatorioMedicoRepository;

	
	
	public void inserir(RespostaRelatorio respostaRelatorio){
		cadastroRelatorioMedicoRepository.insert(respostaRelatorio);
	}
	
	public List<Animal> findAll() {				
		return cadastroRelatorioMedicoRepository.findAll();
	}
	
	public List<PerguntaRelatorio> findAllPerguntas() {	
		return cadastroRelatorioMedicoRepository.findAllPerguntas();
	}
	
	public PerguntaRelatorio findById(int id){
		return cadastroRelatorioMedicoRepository.findById(id);
		
	}


}
