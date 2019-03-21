package br.com.petHealth.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Login;
import br.com.petHealth.service.LoginService;

@Named
@ViewScoped
public class LoginBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1761440157005324488L;
	@Inject
	private LoginService loginService;
	
	
	public void login(){
		for (Login logins : loginService.findAll()) {
			System.out.println(logins.getNome() + " " + logins.getNome());
		}
	}

}
