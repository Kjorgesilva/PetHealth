package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.petHealth.model.Agendamento;
import br.com.petHealth.model.Medico;
import br.com.petHealth.model.PerguntaRelatorio;
import br.com.petHealth.model.RespostaRelatorio;
import br.com.petHealth.service.AgendamentoService;
import br.com.petHealth.service.MedicoService;
import br.com.petHealth.service.RelatorioMedicoService;

@Named
@ViewScoped
public class PreencherRelatorioMedicoBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5152385735575093007L;

	private int id;

	@Inject
	private RelatorioMedicoService cadastroRelatorioMedicoService;

	@Inject
	private AgendamentoService agendamentoService;
	
	private List<RespostaRelatorio> respostaListas;
	private List<PerguntaRelatorio> perguntasLista;
	private RespostaRelatorio respostaRelatorio;
	private String teste;
	private Agendamento agendamento;
	
	
	public void init() {
		agendamento = agendamentoService.findByid(id);
		listarRespostas();
	}

	
	
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
	
	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public void botao() {

		for (PerguntaRelatorio perguntaRelatorio : perguntasLista) {
			respostaRelatorio = new RespostaRelatorio();
			respostaRelatorio.setPergunta(perguntaRelatorio);

			MedicoService medi = new MedicoService();

//			Medico medico = medi.findById(UsuarioBean.getIdUsuario());

			respostaRelatorio.setIdAgenda(id);
			respostaRelatorio.setMedico(agendamento.getMedico());
			respostaRelatorio.setAnimal(agendamento.getAnimal());
			respostaRelatorio.setCliente(agendamento.getCliente());
			respostaRelatorio.setResposta(perguntaRelatorio.getResposta());
			
			cadastroRelatorioMedicoService.inserir(respostaRelatorio);
		}

	}

}
