package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Vacinas;

public class VacinasRepository {
	
	private EntityManager em ;

	public List<Vacinas> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		TypedQuery<Vacinas> vacinas = em.createQuery("FROM Vacinas l", Vacinas.class);		
		List<Vacinas> lista = vacinas.getResultList();		
		return lista;

	}

}
