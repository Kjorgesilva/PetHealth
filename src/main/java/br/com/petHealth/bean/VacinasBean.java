package br.com.petHealth.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.TipoVacinas;
import br.com.petHealth.model.Vacinas;
import br.com.petHealth.service.VacinasService;

@Named
@ViewScoped
public class VacinasBean implements Serializable {

	public void init() {
		listar();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6792217703193989153L;

	@Inject
	private VacinasService vacinasService;

	private List<Vacinas> vacinas;
	private Vacinas vacina;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vacinas getVacina() {
		return vacina;
	}

	public void setVacina(Vacinas vacina) {
		this.vacina = vacina;
	}

	public void listar() {
		vacinas = vacinasService.findAll();
	}

	public VacinasService getVacinasService() {
		return vacinasService;
	}

	public void setVacinasService(VacinasService vacinasService) {
		this.vacinasService = vacinasService;
	}

	public List<Vacinas> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<Vacinas> vacinas) {
		this.vacinas = vacinas;
	}

	public void salvar(Integer id) {
		System.out.println("teste de valor: " + id);
		LocalDateTime hoje = LocalDateTime.now();
		DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		vacina = new Vacinas();
		vacina.setId(id);
		vacina.setDataVacina(hoje);
		vacina.setDataProxima(hoje.plusMonths(2));
		vacina.setVacinaEmDia(true);
		vacina.setDescricao("V3");
		vacina.setAviso("passou aqui");

		vacinasService.atualizar(vacina);
		//
		// System.out.println("Hoje: " + hoje.format(formatadorBarra));
		// System.out.println("meses: " +
		// hoje.plusMonths(2).format(formatadorBarra));

	}

}
