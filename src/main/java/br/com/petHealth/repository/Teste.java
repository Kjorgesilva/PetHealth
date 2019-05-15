package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Vacina;

public class Teste {
	
	public static class teste{
		public static void main(String[] args) {
			EntityManager em; 
			em = JpaConnector.getConnectionMySql();	
			TypedQuery<Vacina> vacina = em.createQuery("SELECT v FROM Vacina v inner join Animal a on a.id = v.idAnimal.id where a.cliente.id =:id ",Vacina.class);
			vacina.setParameter("id", 1);	
			List<Vacina> lista = vacina.getResultList();
			System.out.println(lista.size());
			
			
			
	}
}

}
