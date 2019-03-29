package br.com.petHealth.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.petHealth.model.PerguntaRelatorio;
import br.com.petHealth.model.RespostaRelatorio;
import br.com.petHealth.service.CadastroRelatorioMedicoService;

@Named
@ViewScoped
public class PreencherRelatorioMedicoBean implements Serializable {


	public void init(){	
		listarRespostas();
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 5152385735575093007L;

	private int id;
	@Inject 
	private CadastroRelatorioMedicoService cadastroRelatorioMedicoService;
	private List<RespostaRelatorio>relatoriosListas;
	private RespostaRelatorio respostaRelatorio;





	public CadastroRelatorioMedicoService getCadastroRelatorioMedicoService() {
		return cadastroRelatorioMedicoService;
	}

	public void setCadastroRelatorioMedicoService(CadastroRelatorioMedicoService cadastroRelatorioMedicoService) {
		this.cadastroRelatorioMedicoService = cadastroRelatorioMedicoService;
	}

	
	public RespostaRelatorio getRespostaRelatorio() {
		return respostaRelatorio;
	}

	public List<RespostaRelatorio> getRelatoriosListas() {
		return relatoriosListas;
	}

	public void setRelatoriosListas(List<RespostaRelatorio> relatoriosListas) {
		this.relatoriosListas = relatoriosListas;
	}

	public void setRespostaRelatorio(RespostaRelatorio respostaRelatorio) {
		this.respostaRelatorio = respostaRelatorio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void listarRespostas(){		
		relatoriosListas = cadastroRelatorioMedicoService.findAllResposta();
	}
	

	public void insert(){

		if(respostaRelatorio != null){
			cadastroRelatorioMedicoService.inserir(respostaRelatorio);
		}else{
			System.out.println("Valor null");
		}

	}


}
