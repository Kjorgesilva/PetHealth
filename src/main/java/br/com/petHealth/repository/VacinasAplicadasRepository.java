package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Animal;
import br.com.petHealth.model.TipoVacinas;
import br.com.petHealth.model.Vacina;

public class VacinasAplicadasRepository {
	
	
	private EntityManager em ;

//		public List<Vacina> findAll(int id) {		
//			em = JpaConnector.getConnectionMySql();		
//			TypedQuery<Vacina> vacina = em.createQuery("Select tp FROM Vacina tp "+
//			"INNER JOIN Animal a ON (tp.id = a.id)"+
//			"INNER JOIN VacinaEspecie b ON (tp.id = b.id)"+
//			" WHERE tp.id = :id", Vacina.class);
//			vacina.setParameter("id", id);
//			List<Vacina> lista = vacina.getResultList();			
//			System.out.println(lista.size());		
//			
//			return lista;
//		}	
	
//	public List<Animal> findAll (int id){
//		
//		em = JpaConnector.getConnectionMySql();
//		TypedQuery<Animal> animal = em.createQuery("Select tp FROM Animal tp "+
//				"INNER JOIN Vacina a ON (tp.id = a.id)"+
//				"INNER JOIN VacinaEspecie a ON (tp.id = a.id)"+
//				" WHERE tp.id = :id",Animal.class);
//				animal.setParameter("id", id);
//				List<Animal> lista = animal.getResultList();
//				
//		return lista;
//	}
				

//		public List<Vacina> findAll() {		
//			em = JpaConnector.getConnectionMySql();		
//			Query vacina = em.createQuery("SELECT * FROM Vacina v "+
//					"INNER JOIN v.id_animal "+
//					"INNER JOIN v.id_vacina_tomada_especie ");
//			List<Vacina> lista = vacina.getResultList();			
//			System.out.println(lista.size());	
//			
//			for(int i = 0 ; i < lista.size(); i++){
//				System.out.println(lista.get(i).getId());
//			}
//			
//			return lista;
//		}	
	
	
	public List<Vacina> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		TypedQuery<Vacina> vacina = em.createQuery("FROM Vacina v",Vacina.class);
		List<Vacina> lista = vacina.getResultList();
		System.out.println(lista.size());		
		return lista;
	}	
	
	public List<Animal> listaVacinasPendentes(Integer idAnimal){
		em = JpaConnector.getConnectionMySql();		
		Query animal = em.createQuery("FROM Animal a INNER JOIN FETCH a.idEspecieAnimal e INNER JOIN FETCH e.tipoVacina t");
		List<Animal> lista = animal.getResultList();
		System.out.println(lista.size());		
		return lista;
	}
	
	public List<Vacina> findVacinasPermitidas(Integer id) {		
		em = JpaConnector.getConnectionMySql();		
		Query vacina = em.createQuery("SELECT t FROM Animal a INNER JOIN  a.idEspecieAnimal e INNER JOIN  e.tipoVacina t WHERE a.id = :id");
		vacina.setParameter("id", id);
		List<Vacina> lista = vacina.getResultList();
		return lista;
	}	
	
//	SELECT * FROM tab_vacina_especie
//	INNER JOIN tab_animal ON tab_animal.id_animal = tab_vacina_especie.id_vacina_especie
//	INNER JOIN tab_vacina_tomada_especie ON tab_vacina_tomada_especie.id_vacina_tomada_especie = tab_vacina_especie.id_vacina_especie;

		
}
