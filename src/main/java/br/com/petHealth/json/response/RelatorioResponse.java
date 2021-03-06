package br.com.petHealth.json.response;

import java.io.Serializable;

public class RelatorioResponse implements Serializable {
	
	private int id;
    private String resposta;
    private int idAgenda;
    private String descricaoResposta;
    private String relatoriosPergunta;
    private String relatorioCliente;
    private int idCliente;
    private String relatoriosMedcio;
    private String relatoriosAnimal;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricaoResposta() {
		return descricaoResposta;
	}
	public void setDescricaoResposta(String descricaoResposta) {
		this.descricaoResposta = descricaoResposta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public String getRelatoriosPergunta() {
		return relatoriosPergunta;
	}
	public void setRelatoriosPergunta(String relatoriosPergunta) {
		this.relatoriosPergunta = relatoriosPergunta;
	}
	public String getRelatorioCliente() {
		return relatorioCliente;
	}
	public void setRelatorioCliente(String relatorioCliente) {
		this.relatorioCliente = relatorioCliente;
	}
	public String getRelatoriosMedcio() {
		return relatoriosMedcio;
	}
	public void setRelatoriosMedcio(String relatoriosMedcio) {
		this.relatoriosMedcio = relatoriosMedcio;
	}
	public String getRelatoriosAnimal() {
		return relatoriosAnimal;
	}
	public void setRelatoriosAnimal(String relatoriosAnimal) {
		this.relatoriosAnimal = relatoriosAnimal;
	}
	public int getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	

	

}
