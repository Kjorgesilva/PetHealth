package br.com.petHealth.bean;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.core.SessionManager;
import br.com.petHealth.model.Usuario;
import br.com.petHealth.service.UsuarioService;

@Named
@SessionScoped
public class LoginBean implements Serializable{
	
	private Usuario usuario;
	private String login;
	private String senha;
	
	@Inject
	private UsuarioService usuarioService;
	
	
	public String logar(){
		
		usuario = usuarioService.checkLogin(login, senha);
		SessionManager session = new SessionManager();
		
		session.setVarSessao("cusuIdParam", Integer.toString(usuario.getId()));
		session.setVarSessao("usuarioModel", usuario);
		
		
		
		return "home";
	}
	

	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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


	public boolean isLogado() {
		return (usuario != null);
	}

}
