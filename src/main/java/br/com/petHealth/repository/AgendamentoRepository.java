package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Agendamento;

public class AgendamentoRepository {

	private EntityManager em;

	public void insert(Agendamento agendamento) {
		try {
			em = JpaConnector.getConnectionMySql();
			em.getTransaction().begin();
			em.persist(agendamento);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public List<Agendamento> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		Query agendamento = em.createQuery("FROM Agendamento l INNER JOIN FETCH l.cliente " +
		" INNER JOIN FETCH l.medico " +
		" INNER JOIN FETCH l.endereco");		
		List<Agendamento> lista = agendamento.getResultList();	
	
		return lista;

	}
	
	
}
