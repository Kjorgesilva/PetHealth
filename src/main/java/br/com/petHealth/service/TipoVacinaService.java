package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.TipoVacinas;
import br.com.petHealth.repository.TipoVacinaRepository;

public class TipoVacinaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 503848684773183670L;
	
	@Inject
	private TipoVacinaRepository tipoVacinaRepository;
	
	public List<TipoVacinas> findAll(int id) {
		return tipoVacinaRepository.findAll(id);

	}

	public TipoVacinas findById(int id){			
		return tipoVacinaRepository.findById(id);
	}


	public TipoVacinas atualizar(TipoVacinas vacinas){
		return vacinas = tipoVacinaRepository.atualizar(vacinas);
	}

}
