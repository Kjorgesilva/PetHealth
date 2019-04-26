package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Agendamento;
import br.com.petHealth.model.Endereco;

public class EnderecoRepository {
	
	private EntityManager em;

	public void insert(Endereco endereco) {
		try {
			em = JpaConnector.getConnectionMySql();
			em.getTransaction().begin();
			em.persist(endereco);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		
	}
	public List<Endereco> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		Query endereco = em.createQuery("FROM Endereco e",Endereco.class);		
		List<Endereco> lista = endereco.getResultList();	
	
		return lista;

	}
		
	public Endereco findByid(int id){
		Endereco endereco = null;
		try {
		
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Endereco> agen = em.createQuery("SELECT b FROM Endereco b WHERE b.id = :id",Endereco.class);
			agen.setParameter("id", id);
			endereco = agen.getSingleResult();
			
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
		return endereco;
	}
	

}
