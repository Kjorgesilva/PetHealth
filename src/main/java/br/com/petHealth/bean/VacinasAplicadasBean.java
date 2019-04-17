package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Vacina;
import br.com.petHealth.service.VacinasAplicadasService;

@Named
@ViewScoped
public class VacinasAplicadasBean implements Serializable{
	public void init(){
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
	private int id;
	
	public void listar(){
		listaAnimais = aplicadasService.listaVacinasPendentes(id);
		listaVacinasTomadas = aplicadasService.findVacinasPermitidas(id);
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

	
	
//	public void listar(){
//		listTeste = aplicadasService.findAll(id);
//	}

}
