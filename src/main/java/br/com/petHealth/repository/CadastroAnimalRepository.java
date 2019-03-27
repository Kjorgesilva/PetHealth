package br.com.petHealth.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Animal;

public class CadastroAnimalRepository {
	
	private EntityManager em ;

	public void insert (Animal animal){
		try {
			em = JpaConnector.getConnectionMySql();
			em.getTransaction().begin();
			em.persist(animal);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	public Animal findByid(int id){
		Animal animal = null;
		
		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Animal> ani = em.createQuery("SELECT a FROM Animal a WHERE a.id = :id",Animal.class);
			ani.setParameter("id", id);
			
			animal = ani.getSingleResult();
			
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		
		return animal;
		
		
		
	}
	
	
	public Animal atualizar(Animal animal){
		em = JpaConnector.getConnectionMySql();
		em.getTransaction().begin();
		animal = em.merge(animal);
		em.getTransaction().commit();
		return animal;
		
	}
}
