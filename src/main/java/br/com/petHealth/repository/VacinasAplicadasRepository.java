package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.TipoVacinas;
import br.com.petHealth.model.Vacina;

public class VacinasAplicadasRepository {
	
	
	private EntityManager em ;

		public List<Vacina> findAll(int id) {		
			em = JpaConnector.getConnectionMySql();		
			TypedQuery<Vacina> vacina = em.createQuery("Select tp FROM Vacina tp "+
			"INNER JOIN Animal a ON (tp.id = a.id) WHERE tp.id = :id", Vacina.class);
			vacina.setParameter("id", id);
			List<Vacina> lista = vacina.getResultList();		
			return lista;
		}		
				

}
