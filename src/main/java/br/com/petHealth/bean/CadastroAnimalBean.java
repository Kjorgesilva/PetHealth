package br.com.petHealth.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.model.EspecieAnimal;
import br.com.petHealth.service.AnimalService;
import br.com.petHealth.service.ClienteService;

@Named
@ViewScoped
public class CadastroAnimalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1566842690014543106L;

	@Inject
	private AnimalService cadastroAnimalService;
	
	@Inject
	private ClienteService clienteService;
	
	private Animal animal;
	private Cliente cliente;
	
	private List<Animal> listaAnimais;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@PostConstruct
	public void init() {

		if (id > 0) {
			animal = cadastroAnimalService.findByid(id);
		} else {
			Cliente c = new Cliente();
			EspecieAnimal ea = new EspecieAnimal();
			animal = new Animal();
			animal.setCliente(c);
			animal.setIdEspecieAnimal(ea);

		}
	}

	public AnimalService getCadastroAnimalService() {
		return cadastroAnimalService;
	}

	public void setCadastroAnimalService(AnimalService cadastroAnimalService) {
		this.cadastroAnimalService = cadastroAnimalService;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Animal> getListaAnimais() {
		return listaAnimais;
	}

	public void setListaAnimais(List<Animal> listaAnimais) {
		this.listaAnimais = listaAnimais;
	}


	public String salvar() {
		if (animal.getId() != null && animal.getId() > 0) {
			cadastroAnimalService.atualizar(animal);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Animal atualizado com sucesso."));
		} else {
			cadastroAnimalService.inserirAnimal(animal);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Animal cadastrado com sucesso."));
		}
		return "listaAnimal";
	}
	
	  public List<Cliente> completeTheme(String query) {
	        List<Cliente> listaClientes = clienteService.findByNomeERg(query);
	        return listaClientes;
	    }

}
