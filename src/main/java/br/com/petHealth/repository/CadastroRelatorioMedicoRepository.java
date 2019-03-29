package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Animal;
import br.com.petHealth.model.PerguntaRelatorio;
import br.com.petHealth.model.RespostaRelatorio;

public class CadastroRelatorioMedicoRepository {
	
	private EntityManager em ;
	
	
	public void insert(RespostaRelatorio respostaRelatorio){
		try {
			em = JpaConnector.getConnectionMySql();
			em.getTransaction().begin();
			em.persist(respostaRelatorio);
			em.getTransaction().commit();
		} catch (Exception e) {			
			e.printStackTrace();

		}	
	}
	
	public List<Animal> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		Query animal = em.createQuery("FROM Animal l INNER JOIN FETCH l.cliente");		
		List<Animal> lista = animal.getResultList();	
		
		
		for(int i=0; i<lista.size();i++){
			System.out.println(lista.get(i).getCliente().getNome());		
		}
		return lista;

	}
	
	
	public List<PerguntaRelatorio> findAllPerguntas() {		
		em = JpaConnector.getConnectionMySql();		
		Query animal = em.createQuery("FROM PerguntaRelatorio l ");		
		List<PerguntaRelatorio> lista = animal.getResultList();	
		
		return lista;
	

	}
	
	public PerguntaRelatorio findById(int id){
		PerguntaRelatorio perguntaRelatorio = null;

		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<PerguntaRelatorio> per = em.createQuery("SELECT u FROM PerguntaRelatorio u WHERE u.id = :id",PerguntaRelatorio.class);
			per.setParameter("id", id);

			perguntaRelatorio = per.getSingleResult();

		} catch (NoResultException e) {
			e.printStackTrace();
		}


		return perguntaRelatorio;
	}
	

}
