package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.service.CadastroAnimalService;
import br.com.petHealth.service.CadastroClienteService;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5287031319521232755L;
	
	@Inject
	private CadastroClienteService cadastroClienteService;
	@Inject
	private CadastroAnimalService cadastroAnimalService;
	private Cliente cliente;

	@PostConstruct
	public void init(){
		cliente = new Cliente();
	}
	
	public CadastroClienteService getCadastroClienteService() {
		return cadastroClienteService;
	}

	public void setCadastroClienteService(CadastroClienteService cadastroClienteService) {
		this.cadastroClienteService = cadastroClienteService;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void inserir() {
		cadastroClienteService.insert(cliente);
	}

}
