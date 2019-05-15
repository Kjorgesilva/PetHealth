package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.TipoVacinas;
import br.com.petHealth.model.Vacina;

public class TipoVacinaRepository {

	
	private EntityManager em ;
	
	
	public List<TipoVacinas> findAll(int id_tipo_vacina) {
		em = JpaConnector.getConnectionMySql();		
//		TypedQuery<TipoVacinas> vacinas = em.createQuery("Select tp FROM TipoVacinas tp "+
//		"INNER JOIN EspecieAnimal ea ON (tp.especie.id = ea.id) WHERE tp.especie.id = :id_especie", TipoVacinas.class);		
		TypedQuery<TipoVacinas> vacinas = em.createQuery("Select tp FROM TipoVacinas tp "+
				" where tp.especie.id  = :id_especie", TipoVacinas.class);		
		vacinas.setParameter("id_especie", id_tipo_vacina);
		List<TipoVacinas> lista = vacinas.getResultList();		
		return lista;

	}

	public TipoVacinas findById(int id){
		TipoVacinas vacinas = null;
		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<TipoVacinas> vacina = em.createQuery("SELECT u FROM TipoVacinas u WHERE u.id = :id",TipoVacinas.class);
			vacina.setParameter("id", id);
			vacinas= vacina.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacinas;
	} 



	public TipoVacinas atualizar(TipoVacinas vacinas){
		em = JpaConnector.getConnectionMySql();
		em.getTransaction().begin();
		vacinas = em.merge(vacinas);
		em.getTransaction().commit();
		return vacinas;

	}
	
	
	public void insert (Vacina tipoVacina){
		try {
			em = JpaConnector.getConnectionMySql();
			em.getTransaction().begin();
			em.persist(tipoVacina);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		}		
	}

}
