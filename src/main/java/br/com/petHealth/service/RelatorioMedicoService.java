package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.PerguntaRelatorio;
import br.com.petHealth.model.RespostaRelatorio;
import br.com.petHealth.repository.RelatorioMedicoRepository;


public class RelatorioMedicoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4733715075875694536L;



	@Inject
	private RelatorioMedicoRepository cadastroRelatorioMedicoRepository;

	
	
	public void inserir(RespostaRelatorio respostaRelatorio){
		cadastroRelatorioMedicoRepository.insert(respostaRelatorio);
	}
	
	public List<Animal> findAll() {				
		return cadastroRelatorioMedicoRepository.findAll();
	}
	
	public List<RespostaRelatorio> findAllResposta() {		
		return cadastroRelatorioMedicoRepository.findAllResposta();
	}
	
	public List<PerguntaRelatorio> findAllPergunta() {		
		return cadastroRelatorioMedicoRepository.findAllPergunta();
	}
	
	public PerguntaRelatorio findById(int id){
		return cadastroRelatorioMedicoRepository.findById(id);
		
	}


}
