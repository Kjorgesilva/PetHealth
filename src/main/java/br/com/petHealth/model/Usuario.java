package br.com.petHealth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="tab_usuario")
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6957601394969864366L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int id;	
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "id_perfil")
	private Integer perfil;
	
	
	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	public Usuario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public enum PerfilUsuario {

		CLIENTE(1), MEDICO(2);
		private int id;

		private PerfilUsuario(int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}

	}
	
	public boolean validarSenha(String input) {
		return senha.equals(input);
	}
			
	
}
