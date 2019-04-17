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
	public void init() {
		listar();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2042405758124584680L;

	@Inject
	private VacinasAplicadasService aplicadasService;
	private List<Vacina> listaVacinasTomadas;
	private List<Animal> listaAnimais;
	private Animal animal;
	private List<TipoVacinas> tipoVacinaLista;
	private int id;

	public void listar() {
//		listaAnimais = aplicadasService.listaVacinasPendentes(id);
//		listaVacinasTomadas = aplicadasService.findVacinasPermitidas(id);
		tipoVacinaLista = aplicadasService.listarVacinasTomadas(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VacinasAplicadasService getAplicadasService() {
		return aplicadasService;
	}

	public void setAplicadasService(VacinasAplicadasService aplicadasService) {
		this.aplicadasService = aplicadasService;
	}

	public List<Vacina> getListaVacinasTomadas() {
		return listaVacinasTomadas;
	}

	public void setListaVacinasTomadas(List<Vacina> listaVacinasTomadas) {
		this.listaVacinasTomadas = listaVacinasTomadas;
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

	public List<TipoVacinas> getTipoVacinaLista() {
		return tipoVacinaLista;
	}

	public void setTipoVacinaLista(List<TipoVacinas> tipoVacinaLista) {
		this.tipoVacinaLista = tipoVacinaLista;
	}

	// public void listar(){
	// listTeste = aplicadasService.findAll(id);
	// }

}
