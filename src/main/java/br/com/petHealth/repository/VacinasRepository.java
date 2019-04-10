package br.com.petHealth.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Vacinas;

public class VacinasRepository {

	private EntityManager em ;

	public List<Vacinas> findAll() {
		em = JpaConnector.getConnectionMySql();		
		TypedQuery<Vacinas> vacinas = em.createQuery("FROM Vacinas l", Vacinas.class);		
		List<Vacinas> lista = vacinas.getResultList();		
		return lista;

	}



	public Vacinas findById(int id){
		Vacinas vacinas = null;
		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Vacinas> vacina = em.createQuery("SELECT u FROM Vacinas u WHERE u.id = :id",Vacinas.class);
			vacina.setParameter("id", id);
			vacinas= vacina.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacinas;
	} 



	public Vacinas atualizar(Vacinas vacinas){
		em = JpaConnector.getConnectionMySql();
		em.getTransaction().begin();
		vacinas = em.merge(vacinas);
		em.getTransaction().commit();
		return vacinas;

	}

}
