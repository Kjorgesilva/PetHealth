package br.com.petHealth.core;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaConnector {
	
	private static EntityManager em;
	
	public static EntityManager getConnectionMySql(){
		
		if(em == null){
			em = Persistence.createEntityManagerFactory("mySqlConnector").createEntityManager();
			System.out.println("passou aqui" + em);
		}
		return em;
	}
	

}
