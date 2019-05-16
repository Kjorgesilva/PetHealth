package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.model.Medico;
import br.com.petHealth.model.PerguntaRelatorio;
import br.com.petHealth.model.RespostaRelatorio;
import br.com.petHealth.service.AnimalService;
import br.com.petHealth.service.ClienteService;
import br.com.petHealth.service.MedicoService;
import br.com.petHealth.service.RelatorioMedicoService;

@Named
@ViewScoped
public class PreencherRelatorioMedicoBean implements Serializable {

	public void init() {
		listarRespostas();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5152385735575093007L;

	private int id;

	@Inject
	private RelatorioMedicoService cadastroRelatorioMedicoService;

	private List<RespostaRelatorio> respostaListas;
	private List<PerguntaRelatorio> perguntasLista;
	private RespostaRelatorio respostaRelatorio;
	private String teste;
	
	

	public String getTeste() {
		return teste;
	}



	public void setTeste(String teste) {
		this.teste = teste;
	}

	public List<PerguntaRelatorio> getPerguntasLista() {
		return perguntasLista;
	}

	public void setPerguntasLista(List<PerguntaRelatorio> perguntasLista) {
		this.perguntasLista = perguntasLista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RelatorioMedicoService getCadastroRelatorioMedicoService() {
		return cadastroRelatorioMedicoService;
	}

	public void setCadastroRelatorioMedicoService(RelatorioMedicoService cadastroRelatorioMedicoService) {
		this.cadastroRelatorioMedicoService = cadastroRelatorioMedicoService;
	}

	public List<RespostaRelatorio> getRespostaListas() {
		return respostaListas;
	}

	public void setRespostaListas(List<RespostaRelatorio> respostaListas) {
		this.respostaListas = respostaListas;
	}

	public RespostaRelatorio getRespostaRelatorio() {
		return respostaRelatorio;
	}

	public void setRespostaRelatorio(RespostaRelatorio respostaRelatorio) {
		this.respostaRelatorio = respostaRelatorio;
	}

	public void listarRespostas() {
		perguntasLista = cadastroRelatorioMedicoService.findAllPergunta();
	}

	public void botao() {
		
		
		for (PerguntaRelatorio perguntaRelatorio : perguntasLista) {
			respostaRelatorio = new RespostaRelatorio();
			respostaRelatorio.setPergunta(perguntaRelatorio);
			
		//instancia seus services de animal, cliente e médido
		//findById(int id);
		//Animal animal = animalService.findById(idAnimal)
		//respostaRelatorio.setAnimal(animal);
		MedicoService medi = new MedicoService();
		AnimalService anim = new AnimalService();
		ClienteService cli = new ClienteService();
		
		

		Medico medico = medi.findById(1);
		Animal animal = anim.findByid(1);
		Cliente cliente = cli.findByid(1);
		respostaRelatorio.setIdAgenda(1);
		
		
		respostaRelatorio.setMedico(medico);
		respostaRelatorio.setAnimal(animal);
		respostaRelatorio.setCliente(cliente);
			
		
		if (respostaRelatorio != null) {
			respostaRelatorio.setResposta(perguntaRelatorio.getResposta());
			cadastroRelatorioMedicoService.inserir(respostaRelatorio);
		} else {
			System.out.println("valor nulo");
		}
		}

	}
	


}
