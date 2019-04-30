package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Cliente;

public class ClienteRepository {
	
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
	
	
	public List<Cliente> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		TypedQuery<Cliente> cliente = em.createQuery("FROM Cliente l", Cliente.class);		
		List<Cliente> lista = cliente.getResultList();		
		return lista;

	}
	
	public Cliente atualizar(Cliente cliente){
		em = JpaConnector.getConnectionMySql();
		em.getTransaction().begin();
		cliente = em.merge(cliente);
		em.getTransaction().commit();
		return cliente;
		
	}
	
	public Cliente findByid(int id){
		Cliente cliente = null;
		
		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Cliente> ani = em.createQuery("SELECT a FROM Cliente a WHERE a.id = :id",Cliente.class);
			ani.setParameter("id", id);
			
			cliente = ani.getSingleResult();
			
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		
		return cliente;
		
		
		
	}

}
