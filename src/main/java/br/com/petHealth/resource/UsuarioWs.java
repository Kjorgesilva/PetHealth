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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.primefaces.json.JSONObject;

import br.com.petHealth.json.response.UsuarioResponse;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.model.Usuario;
import br.com.petHealth.service.ClienteService;
import br.com.petHealth.service.UsuarioService;

@Path("/usuario")
public class UsuarioWs implements Serializable {
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private ClienteService clienteService;
	
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
	public UsuarioResponse getTestService(String json) {
		JSONObject jsonObject = new JSONObject(json);
		Usuario usuario = new Usuario();
		Cliente cliente = new Cliente();
		UsuarioResponse usuarioRsponse = new UsuarioResponse();
		
		System.out.println(json);
		
		usuario =  usuarioService.checkLogin(jsonObject.getString("login"),jsonObject.getString("senha"));
		
		cliente =  clienteService.findByidCliente(usuario.getId());
		
		usuarioRsponse.setIdCliente(cliente.getId());
		usuarioRsponse.setLogin(usuario.getLogin());
		usuarioRsponse.setSenha(usuario.getSenha());
		usuarioRsponse.setNome(usuario.getNome());
		usuarioRsponse.setEmail(usuario.getEmail());
		
		System.out.println("idCleinte: " + usuarioRsponse.getIdCliente());
			
		
		return usuarioRsponse;
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Path("/listaTeste")
//	public FormularioServico listaTeste() {
//		System.out.println("Chegou" + idTecnico);
//		FormularioServico formularios = formularioServicoService.findById(936);
//		return formularios;
//	}

	
//                          Com Parametro...
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Path("{idTecnico}/listaTeste")
//	public FormularioServico listaTeste(@PathParam("idTecnico") Integer idTecnico) {
//		System.out.println("Chegou" + idTecnico);
//		FormularioServico formularios = formularioServicoService.findById(936);
//		return formularios;
//	}

	
}
