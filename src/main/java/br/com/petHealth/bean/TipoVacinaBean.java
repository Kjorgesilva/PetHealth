package br.com.petHealth.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.TipoVacinas;
import br.com.petHealth.model.VacinaEspecie;
import br.com.petHealth.model.Vacina;
import br.com.petHealth.service.TipoVacinaService;

@Named
@ViewScoped
public class TipoVacinaBean implements Serializable {

	public void init() {
		listar();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4765268459997194457L;
	
	@Inject
	private TipoVacinaService tipoVacinaService;
	
	private List<TipoVacinas> listaVacinas;
	private TipoVacinas tiopoVacinas;
	private Vacina vacinaTomadaEspecie;
	private int id;
	
	
	public TipoVacinaService getTipoVacinaService() {
		return tipoVacinaService;
	}
	public void setTipoVacinaService(TipoVacinaService tipoVacinaService) {
		this.tipoVacinaService = tipoVacinaService;
	}
	public List<TipoVacinas> getListaVacinas() {
		return listaVacinas;
	}
	public void setListaVacinas(List<TipoVacinas> listaVacinas) {
		this.listaVacinas = listaVacinas;
	}
	public TipoVacinas getTiopoVacinas() {
		return tiopoVacinas;
	}
	public void setTiopoVacinas(TipoVacinas tiopoVacinas) {
		this.tiopoVacinas = tiopoVacinas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void listar(){
		listaVacinas = tipoVacinaService.findAll(id);
	}

		
	public void inserir(Integer id){
		LocalDateTime hoje = LocalDateTime.now();		
		vacinaTomadaEspecie = new Vacina();
		vacinaTomadaEspecie.setAviso("aviso");
		vacinaTomadaEspecie.setDataVacina(hoje);
		vacinaTomadaEspecie.setDataProxima(hoje.plusMonths(2));

		System.out.println("valor do id: " + id);	
				
		tipoVacinaService.insert(vacinaTomadaEspecie);
	}
	
	
//	public void salvar(Integer id) {
//		System.out.println("teste de valor: " + id);
//		LocalDateTime hoje = LocalDateTime.now();
//		DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//		vacina = new Vacinas();
//		vacina.setId(id);
//		vacina.setDataVacina(hoje);
//		vacina.setDataProxima(hoje.plusMonths(2));
//		vacina.setVacinaEmDia(true);
//		vacina.setDescricao("V3");
//		vacina.setAviso("passou aqui");
//
//		vacinasService.atualizar(vacina);
//		//
//		// System.out.println("Hoje: " + hoje.format(formatadorBarra));
//		// System.out.println("meses: " +
//		// hoje.plusMonths(2).format(formatadorBarra));
//
//	}
	

}
