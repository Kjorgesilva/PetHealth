package br.com.petHealth.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONObject;

import br.com.petHealth.model.Usuario;
import br.com.petHealth.service.UsuarioService;

@Path("/usuario")
public class UsuarioWs implements Serializable {
	
	@Inject
	private UsuarioService usuarioService;
	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public Usuario getTestService(@QueryParam("login") String login, @QueryParam("senha") String senha) {
//		System.out.println("teste");
//		Usuario usuario = new Usuario();
//		usuario =  usuarioService.checkLogin(login, senha); 
//		return usuario;
//	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getTestService(String json) {
		JSONObject jsonObject = new JSONObject(json);
		
		System.out.println(json);
		Usuario usuario = new Usuario();
		usuario =  usuarioService.checkLogin(jsonObject.getString("login"),
				jsonObject.getString("senha")); 
		return usuario;
	}


	
}
