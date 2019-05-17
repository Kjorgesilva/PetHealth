package br.com.petHealth.bean;


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import br.com.petHealth.core.SessionManager;
import br.com.petHealth.model.PerfilAplicacao;
import br.com.petHealth.model.Usuario;
import br.com.petHealth.service.MenuService;
import br.com.petHealth.service.UsuarioService;

@Named
@SessionScoped
public class LoginBean implements Serializable{
	
	private Usuario usuario;
	private String login;
	private String senha;
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private MenuService menuService;
	
	private List<PerfilAplicacao> listaAplicativos;
	
	public String logar(){
		
		try {
			usuario = usuarioService.checkLogin(login, senha);
			SessionManager session = new SessionManager();
			
			session.setVarSessao("cusuIdParam", Integer.toString(usuario.getId()));
			session.setVarSessao("cusuIdPerfilParam", usuario.getPerfil());
			session.setVarSessao("usuarioModel", usuario);
			
			listaAplicativos  = menuService.montaMenuUsuario(usuario.getPerfil());
			
			
			return "home";
			
		}catch (NoResultException e) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Login e/ou senha incorreto."));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String sair() {
		String retorno = "login";
		FacesContext facesContext = FacesContext.getCurrentInstance();  
		HttpSession session = (HttpSession) facesContext .getExternalContext().getSession(false);  
		session.invalidate();  
		return retorno;
	}
	

	public boolean isLogado() {
		return (usuario != null);
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

	

	public List<PerfilAplicacao> getListaAplicativos() {
		return listaAplicativos;
	}


	public void setListaAplicativos(List<PerfilAplicacao> listaAplicativos) {
		this.listaAplicativos = listaAplicativos;
	}


}
