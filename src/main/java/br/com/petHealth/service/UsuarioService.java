package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import br.com.petHealth.model.Usuario;
import br.com.petHealth.repository.UsuarioRepository;

public class UsuarioService implements Serializable{
	
	@Inject
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
	return usuarioRepository.findAll();
	
	}
	
	public Usuario checkLogin(String login,String senha){
		return usuarioRepository.checkLogin(login, senha);
	}
	
	public Usuario findById(int id){
		return usuarioRepository.findById(id);
		
	}
	
	
}
