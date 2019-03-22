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
@Table(name="tab_histoico")
public class Historico implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3758814248799273823L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_historico")
	private int id;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_agendamento")
	private Agendamento  agendamento ;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_relatorio_medico")
	private RelatorioMedico relatorio_medico;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Agendamento getAgendamento() {
		return agendamento;
	}


	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}


	public RelatorioMedico getRelatorio_medico() {
		return relatorio_medico;
	}


	public void setRelatorio_medico(RelatorioMedico relatorio_medico) {
		this.relatorio_medico = relatorio_medico;
	}

}
