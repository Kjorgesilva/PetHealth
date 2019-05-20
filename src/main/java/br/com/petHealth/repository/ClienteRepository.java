package br.com.petHealth.repository;

import java.util.ArrayList;
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
	
	public Cliente findByidCliente(int id){
		Cliente cliente = null;
		
		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Cliente> ani = em.createQuery("SELECT a FROM Cliente a WHERE a.usuario.id = :id",Cliente.class);
			ani.setParameter("id", id);			
			cliente = ani.getSingleResult();			
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
		return cliente;			
		
	}
	
	public List<Cliente> findCliente(Cliente cliente){
		
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			em = JpaConnector.getConnectionMySql();
			StringBuilder filtro = new StringBuilder();
			
			if(cliente.getNome() != null && cliente.getNome().trim().length() > 0){
				filtro.append(" AND a.nome LIKE UPPER(:nome)");
			}
			if(cliente.getRg() != null && cliente.getRg().trim().length() > 0){
				filtro.append(" AND a.rg = :rg");
			}
			TypedQuery<Cliente> ani = em.createQuery("SELECT a FROM Cliente a WHERE 1 = 1 " + filtro.toString(),Cliente.class);
			
			if(cliente.getNome() != null && cliente.getNome().trim().length() > 0){
				ani.setParameter("nome", "%"+cliente.getNome().toUpperCase()+"%");			
			}
			if(cliente.getRg() != null && cliente.getRg().trim().length() > 0){
				ani.setParameter("rg", cliente.getRg());			
			}
			
			lista = (List<Cliente>) ani.getResultList();			
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Cliente> findByNomeERg(String query){
		List<Cliente> cliente = new ArrayList<Cliente>();
		
		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Cliente> ani = em.createQuery("SELECT a FROM Cliente a WHERE UPPER(a.nome) LIKE :query",Cliente.class);
			ani.setParameter("query", "%" + query +"%");			
			cliente = ani.getResultList();		
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
		return cliente;			
		
	}

}
