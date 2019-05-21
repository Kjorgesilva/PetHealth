package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		" INNER JOIN FETCH l.animal " +
		" INNER JOIN FETCH l.endereco ORDER BY l.id DESC");		
		List<Agendamento> lista = agendamento.getResultList();	
	
		return lista;

	}
		
	public Agendamento findByid(int id){
		Agendamento agenda = null;
		try {
		
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Agendamento> agen = em.createQuery("SELECT b FROM Agendamento b WHERE b.id = :id",Agendamento.class);
			agen.setParameter("id", id);
			agenda = agen.getSingleResult();
			
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
		return agenda;
	}
	
}
