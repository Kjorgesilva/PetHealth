package br.com.petHealth.resource;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.petHealth.model.Usuario;
import br.com.petHealth.service.UsuarioService;

@Path("/usuario")
public class UsuarioWs implements Serializable {
	
	@Inject
	private UsuarioService usuarioService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getTestService(@QueryParam("login") String login, @QueryParam("senha") String senha) {
		Usuario usuario = new Usuario();
		usuario =  usuarioService.checkLogin(login, senha); 
		return usuario;
	}

}
