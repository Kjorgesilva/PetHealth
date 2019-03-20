package br.com.petHealth.service;

import java.util.List;

import javax.inject.Inject;
import br.com.petHealth.model.Login;
import br.com.petHealth.repository.LoginRepository;

public class LoginService {
	
	@Inject
	private LoginRepository loginRepository;

	public List<Login> findAll() {
	return loginRepository.findAll();
	
	} 
	
	
}
