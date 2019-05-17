package br.com.petHealth.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.model.Medico;

public class MedicoRepository {

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

	public List<Medico> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		TypedQuery<Medico> medico = em.createQuery("FROM Medico l", Medico.class);		
		List<Medico> lista = medico.getResultList();		
		return lista;

	}

	public Medico findById(int id){
		Medico medico = null;

		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Medico> medi = em.createQuery("SELECT u FROM Medico u WHERE u.id = :id",Medico.class);
			medi.setParameter("id", id);

			medico = medi.getSingleResult();

		} catch (NoResultException e) {
			e.printStackTrace();
		}


		return medico;
	}
	
	
	public Medico atualizar(Medico medico){
		em = JpaConnector.getConnectionMySql();
		em.getTransaction().begin();
		medico = em.merge(medico);
		em.getTransaction().commit();
		return medico;
		
	}
	
public List<Medico> filtrarMedico(Medico medico){
		
		List<Medico> lista = new ArrayList<Medico>();
		try {
			em = JpaConnector.getConnectionMySql();
			StringBuilder filtro = new StringBuilder();
			
			if(medico.getNome() != null && medico.getNome().trim().length() > 0){
				filtro.append(" AND a.nome = :nome");
			}
			
			TypedQuery<Medico> me = em.createQuery("SELECT a FROM Medico a WHERE 1 = 1 " + filtro.toString(),Medico.class);
			
			if(medico.getNome() != null && medico.getNome().trim().length() > 0){
				me.setParameter("nome", medico.getNome());			
			}
			
			lista = (List<Medico>) me.getResultList();			
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return lista;
	}


}
