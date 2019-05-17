package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.PerfilAplicacao;
import br.com.petHealth.repository.MenuRepository;

public class MenuService implements Serializable{

	private static final long serialVersionUID = -2218009529490728109L;

	@Inject
	private MenuRepository  menuRepository;
	
	
	public List<PerfilAplicacao> montaMenuUsuario(Integer ridPerfil){
		return menuRepository.montaMenuUsuario(ridPerfil);
	}
	
}
