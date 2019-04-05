package br.com.petHealth.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import br.com.petHealth.core.JpaConnector;
import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Usuario;

public class UsuarioRepository {


	private EntityManager em ;


	public List<Usuario> findAll() {		
		em = JpaConnector.getConnectionMySql();		
		TypedQuery<Usuario> logins = em.createQuery("FROM Usuario l", Usuario.class);		
		List<Usuario> lista = logins.getResultList();		
		return lista;

	}

	public Usuario checkLogin(String login,String senha){
		Usuario loginUsuario = null;
		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Usuario> log = em.createQuery("SELECT l FROM Usuario l WHERE l.login = :login AND l.senha = :senha",Usuario.class);
			log.setParameter("login", login);
			log.setParameter("senha", senha);				
			loginUsuario = log.getSingleResult();				
		} catch (NoResultException e) {
			e.printStackTrace();
		}	
		return loginUsuario;

	}
	
	public Usuario findById(int id){
		Usuario usuario = null;
		
		try {
			em = JpaConnector.getConnectionMySql();
			TypedQuery<Usuario> usu = em.createQuery("SELECT u FROM Usuario u WHERE u.id = :id",Usuario.class);
			usu.setParameter("id", id);
			
			usuario = usu.getSingleResult();
			
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
		
		return usuario;
	}


	public Integer insert (Usuario login){
		try {
			em = JpaConnector.getConnectionMySql();
			em.getTransaction().begin();
			em.persist(login);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();


		}
		return login.getId();

	}
	
	
public Usuario findByLogin(String login) {
		
		try {

			em = JpaConnector.getConnectionMySql();
			TypedQuery<Usuario> query = em.createQuery(
				"SELECT u "+
				"FROM "+
				"	Usuario u "+
				"WHERE "+
				" u.login = :login",Usuario.class);
			query.setParameter("login", login);
			
			Usuario usuario = query.getSingleResult();
			
			return usuario;
			
		} catch (NoResultException nre) {
			return null;
		}
		
	}




}
