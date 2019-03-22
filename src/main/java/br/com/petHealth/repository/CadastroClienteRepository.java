package br.com.petHealth.repository;

import javax.persistence.EntityManager;
import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Cliente;

public class CadastroClienteRepository {
	
	private EntityManager em ;


	
	
	public void insert (Cliente cliente){
		try {
			em = JpaConnector.getConnectionMySql();
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			
			e.printStackTrace();

		}		
	}

}
