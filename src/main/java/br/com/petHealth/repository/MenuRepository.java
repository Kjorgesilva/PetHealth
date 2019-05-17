package br.com.petHealth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Endereco;
import br.com.petHealth.model.PerfilAplicacao;

public class MenuRepository {
	
	private EntityManager em;

	public List<PerfilAplicacao> montaMenuUsuario(Integer ridPerfil){
		
		em = JpaConnector.getConnectionMySql();		
		Query menu = em.createQuery("FROM PerfilAplicacao perApl INNER JOIN FETCH perApl.aplicacao apl INNER JOIN FETCH perApl.perfil per WHERE per.id = :id AND apl.exibeMenu = 'S'");
		menu.setParameter("id", ridPerfil);
		List<PerfilAplicacao> lista = menu.getResultList();
		return lista;	
	}

}
