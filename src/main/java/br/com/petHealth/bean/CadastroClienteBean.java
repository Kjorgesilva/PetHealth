package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.service.AnimalService;
import br.com.petHealth.service.ClienteService;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5287031319521232755L;
	
	@Inject
	private ClienteService cadastroClienteService;
	@Inject
	private AnimalService cadastroAnimalService;
	private Cliente cliente;
	private int id;

	@PostConstruct
	public void init(){
		
		if(id>0){
			cliente = cadastroClienteService.findByid(id);
		}else{
		
		cliente = new Cliente();
	}}
	
	public AnimalService getCadastroAnimalService() {
		return cadastroAnimalService;
	}

	public void setCadastroAnimalService(AnimalService cadastroAnimalService) {
		this.cadastroAnimalService = cadastroAnimalService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClienteService getCadastroClienteService() {
		return cadastroClienteService;
	}

	public void setCadastroClienteService(ClienteService cadastroClienteService) {
		this.cadastroClienteService = cadastroClienteService;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String inserir() {
		cadastroClienteService.insert(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Cliente Cadastrado com sucesso."));
        return "listaCliente";
	}

	public void salvar() {		
		if(cliente.getId() != null && cliente.getId() > 0){
			cadastroClienteService.atualizar(cliente);
		}else {
			cadastroClienteService.insert(cliente);
		}
		
	}
	
}
