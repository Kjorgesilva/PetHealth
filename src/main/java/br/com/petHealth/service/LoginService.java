package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import br.com.petHealth.model.Login;
import br.com.petHealth.repository.LoginRepository;

public class LoginService implements Serializable{
	
	@Inject
	private LoginRepository loginRepository;

	public List<Login> findAll() {
	return loginRepository.findAll();
	
	} 
	
	
}
