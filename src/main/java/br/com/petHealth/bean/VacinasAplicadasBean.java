package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.TipoVacinas;
import br.com.petHealth.model.Vacina;
import br.com.petHealth.service.VacinasAplicadasService;

@Named
@ViewScoped
public class VacinasAplicadasBean implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2042405758124584680L;

	@Inject
	private VacinasAplicadasService aplicadasService;
	private List<Animal> listaAnimais;
	private Animal animal;
	private List<Vacina> vacinaLista;
	private int id;
	private int idEspecie;
	
	
	public void init() {
		listar();
	}

	public void listar() {		
		
		vacinaLista = aplicadasService.listarVacinasTomadas(id);	
				
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public VacinasAplicadasService getAplicadasService() {
		return aplicadasService;
	}

	public void setAplicadasService(VacinasAplicadasService aplicadasService) {
		this.aplicadasService = aplicadasService;
	}

	public List<Animal> getListaAnimais() {
		return listaAnimais;
	}

	public void setListaAnimais(List<Animal> listaAnimais) {
		this.listaAnimais = listaAnimais;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public List<Vacina> getVacinaLista() {

		return vacinaLista;
	}

	public void setVacinaLista(List<Vacina> tipoVacinaLista) {
		this.vacinaLista = tipoVacinaLista;
	}


}
