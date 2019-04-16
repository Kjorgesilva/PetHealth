package br.com.petHealth.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.petHealth.model.Usuario;
import br.com.petHealth.service.UsuarioService;

@Named
@ViewScoped
public class UsuarioBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1761440157005324488L;
	@Inject
	private UsuarioService usuarioService;
	private String login, senha;
	private Usuario loginUsuario;
	 

	public void login(){
		for (Usuario logins : usuarioService.findAll()) {
			System.out.println(logins.getNome() + " " + logins.getNome());
		}
	}
	
	public String  checkLogin(){
				
		loginUsuario = usuarioService.checkLogin(login, senha);
		
		if(loginUsuario != null){
			return "home.xhtml";
		}	
		else{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha Invalidos...", null));
		}
		return null;
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Usuario getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(Usuario loginUsuario) {
		this.loginUsuario = loginUsuario;
	}	
	
	

}
