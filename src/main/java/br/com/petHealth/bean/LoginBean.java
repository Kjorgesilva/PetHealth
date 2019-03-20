package br.com.petHealth.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.service.LoginService;

@Named
@ViewScoped
public class LoginBean {
	
	@Inject
	private LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public void login(){
		System.out.println("chegou");
	}

}
