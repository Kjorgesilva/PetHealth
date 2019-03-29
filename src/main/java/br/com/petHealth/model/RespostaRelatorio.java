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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tab_resposta_relatorio")
public class RespostaRelatorio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6087296141693742613L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_resposta_relatorio")
	private Integer id;	
	
	@Column(name="resposta")
	private String resposta;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pergunta_relatorio")
	private PerguntaRelatorio  pergunta ;
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public PerguntaRelatorio getPergunta() {
		return pergunta;
	}

	public void setPergunta(PerguntaRelatorio pergunta) {
		this.pergunta = pergunta;
	}



}
