package br.com.petHealth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tab_resposta_relatorio")
public class RespostaRelatorio implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_resposta_relatorio")
	private int id;	
	
	@Column(name="resposta")
	private String resposta;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pergunta_relatorio")
	private PerguntaRelatorio  pergunta_relatorio ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_relatorio_medico")
	private RelatorioMedico relatorio_medico;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public PerguntaRelatorio getPergunta_relatorio() {
		return pergunta_relatorio;
	}

	public void setPergunta_relatorio(PerguntaRelatorio pergunta_relatorio) {
		this.pergunta_relatorio = pergunta_relatorio;
	}

	public RelatorioMedico getRelatorio_medico() {
		return relatorio_medico;
	}

	public void setRelatorio_medico(RelatorioMedico relatorio_medico) {
		this.relatorio_medico = relatorio_medico;
	}

}
