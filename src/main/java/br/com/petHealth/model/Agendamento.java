package br.com.petHealth.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="tab_agendamento")
public class Agendamento implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2703927585425751509L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agendamento")
	private int id;	
	
	@Column(name = "data_de_inicio")
	private LocalDateTime dataInicio;
	
	@Column(name = "data_de_fim")
	private LocalDateTime dataFim;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_animal")
	private Animal animal;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_medico")
	private Medico medico;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	@Column(name = "status_agenda")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	
	

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
