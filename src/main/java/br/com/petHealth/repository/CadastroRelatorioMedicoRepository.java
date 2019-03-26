package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Animal;
import br.com.petHealth.model.RelatorioMedico;

public class CadastroRelatorioMedicoRepository {
	
	private EntityManager em ;
	
	public void insert (RelatorioMedico relatorioMedico){
		try {
			em = JpaConnector.getConnectionMySql();
			em.getTransaction().begin();
			em.persist(relatorioMedico);
			em.getTransaction().commit();
		} catch (Exception e) {			
			e.printStackTrace();

		}		
	}
	
	public List<Animal> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		Query animal = em.createQuery("FROM Animal l INNER JOIN FETCH l.cliente c");		
		List<Animal> lista = animal.getResultList();		
		return lista;

	}

}
