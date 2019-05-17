package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Cliente;
import br.com.petHealth.service.ClienteService;

@Named
@ViewScoped
public class ListarClienteBean implements Serializable {
	
	public void init(){
		cli = new Cliente();
		listar();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2379132029806868994L;

	@Inject
	private ClienteService cadastroClienteService;
	
	private List<Cliente> cliente;
	private Cliente cli;
	
	public ClienteService getCadastroClienteService() {
		return cadastroClienteService;
	}

	public void setCadastroClienteService(ClienteService cadastroClienteService) {
		this.cadastroClienteService = cadastroClienteService;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}
	

	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}

	public void listar(){
		cliente = cadastroClienteService.findAll();		
	}
	
	public void filtrar(){
		cliente.clear();
		cliente = cadastroClienteService.filtrarCliente(cli);
	}

	
	

}
