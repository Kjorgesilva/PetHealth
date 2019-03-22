package br.com.petHealth.repository;

import javax.persistence.EntityManager;
import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Medico;

public class CadastroMedicoRepository {
	
private EntityManager em ;
		
	public void insert (Medico medico){
		try {
			em = JpaConnector.getConnectionMySql();
			em.getTransaction().begin();
			em.persist(medico);
			em.getTransaction().commit();
		} catch (Exception e) {			
			e.printStackTrace();

		}		
	}

}
