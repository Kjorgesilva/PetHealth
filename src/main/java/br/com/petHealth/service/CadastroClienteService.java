package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.model.Usuario;
import br.com.petHealth.model.Vacinas;
import br.com.petHealth.model.Usuario.PerfilUsuario;
import br.com.petHealth.repository.CadastroAnimalRepository;
import br.com.petHealth.repository.CadastroClienteRepository;
import br.com.petHealth.repository.UsuarioRepository;

public class CadastroClienteService implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2706542046084886553L;
	@Inject
	private CadastroClienteRepository cadastroClienteRepository;
	
	@Inject
	private UsuarioRepository loginRepository;
	
	public void insert (Cliente cliente){
	
		Usuario usuario = new Usuario();
		usuario.setEmail(cliente.getEmail());
		usuario.setNome(cliente.getNome());
		usuario.setSenha("111");
		usuario.setLogin("C" + cliente.getRg());
		usuario.setPerfil(PerfilUsuario.CLIENTE.getId());
		
		Integer id = loginRepository.insert(usuario);
		
		cliente.setUsuario(usuario);
		cadastroClienteRepository.insert(cliente);
		
	}
	
	
	public List<Cliente> findAll() {
		return cadastroClienteRepository.findAll();
		
		}
	
	public Cliente atualizar(Cliente cliente){		
		return cliente = cadastroClienteRepository.atualizar(cliente);
	}
	
	public Cliente findByid(int id){
		cadastroClienteRepository = new CadastroClienteRepository();
		return cadastroClienteRepository.findByid(id);
	}
	
	
	

}
