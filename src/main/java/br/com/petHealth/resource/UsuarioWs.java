package br.com.petHealth.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuario")
public class UsuarioWs {
	


@GET
@Produces(MediaType.TEXT_PLAIN)
public String getTestService() {
return "Hello World! This is coming from webservice!!";
}

}
