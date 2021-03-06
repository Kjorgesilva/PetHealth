package br.com.petHealth.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Medico;
import br.com.petHealth.service.MedicoService;


@Named
@ViewScoped
public class CadastroMedicoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4373569129906307340L;
	
	
	@Inject
	private MedicoService cadastroMedicoService;
	private Medico medico;
	private int id;
	@PostConstruct
	public void init(){
		
		if(id > 0){
			medico = cadastroMedicoService.findById(id);		
		}else {
			medico = new Medico();
		}
		
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public MedicoService getCadastroMedicoService() {
		return cadastroMedicoService;
	}

	public void setCadastroMedicoService(MedicoService cadastroMedicoService) {
		this.cadastroMedicoService = cadastroMedicoService;
	}
	
	public String salvar() {		
		if(medico.getId() != null && medico.getId() > 0){
			cadastroMedicoService.atualizar(medico);
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "M�dico atualizado com sucesso."));
		}else {
			cadastroMedicoService.insert(medico);
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "M�dico cadastrado com sucesso."));

		}
        return "listaMedico";
		
	}

}
