package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Login;

public class LoginRepository {

		
	private EntityManager em ;
		
	
		public List<Login> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		TypedQuery<Login> logins = em.createQuery("FROM Login l", Login.class);		
		List<Login> lista = logins.getResultList();		
		return lista;
		
	}

		
	

}
