package br.com.petHealth.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Cliente;

public class AnimalRepository {
	
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
	
	public List<Animal> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		Query animal = em.createQuery("FROM Animal l INNER JOIN FETCH l.cliente");		
		List<Animal> lista = animal.getResultList();	
		
//		for(int i=0; i<lista.size();i++){
//			System.out.println(lista.get(i).getCliente().getNome());		
//		}
		return lista;

	}
	
	
	public List<Animal> findByidCliente(int id){
		List<Animal> lista = new ArrayList<>();	
		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Animal> ani = em.createQuery("SELECT a FROM Animal a WHERE a.cliente.id = :id ",Animal.class);
			ani.setParameter("id", id);			
			lista = ani.getResultList();			
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		
		return lista;
		
		
		
	}
	
public List<Animal> findAnimal(Animal animal){
		
		List<Animal> lista = new ArrayList<Animal>();
		try {
			em = JpaConnector.getConnectionMySql();
			StringBuilder filtro = new StringBuilder();
			
			if(animal.getNome() != null && animal.getNome().trim().length() > 0){
				filtro.append(" AND a.nome = :nome");
			}
			TypedQuery<Animal> ani = em.createQuery("SELECT a FROM Animal a WHERE 1 = 1 " + filtro.toString(),Animal.class);
			
			if(animal.getNome() != null && animal.getNome().trim().length() > 0){
				ani.setParameter("nome", animal.getNome());			
			}
			lista = (List<Animal>) ani.getResultList();			
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	

	
}
