package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.petHealth.model.Animal;
import br.com.petHealth.model.Cliente;
import br.com.petHealth.model.Usuario;
import br.com.petHealth.model.Usuario.PerfilUsuario;
import br.com.petHealth.repository.AnimalRepository;
import br.com.petHealth.repository.ClienteRepository;
import br.com.petHealth.repository.UsuarioRepository;
import br.com.petHealth.utils.EmailUtils;
import br.com.petHealth.utils.SenhaRandom;

@Named(value="clienteService")
@RequestScoped
public class ClienteService implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2706542046084886553L;
	@Inject
	private ClienteRepository cadastroClienteRepository;
	
	@Inject
	private UsuarioRepository loginRepository;
	
	public void insert (Cliente cliente){
	
		Usuario usuario = new Usuario();
		usuario.setEmail(cliente.getEmail());
		usuario.setNome(cliente.getNome());
		usuario.setSenha(SenhaRandom.getSenhaRandom());
		usuario.setLogin(cliente.getEmail());
		usuario.setPerfil(PerfilUsuario.CLIENTE.getId());
		
		Integer id = loginRepository.insert(usuario);
		
		cliente.setUsuario(usuario);
		cadastroClienteRepository.insert(cliente);
		

		EmailUtils.enviarHotmail(usuario.getEmail(), usuario.getNome(), usuario.getSenha());
		
		
	}
	
	public List<Cliente> findByNomeERg(String query){
		return cadastroClienteRepository.findByNomeERg(query);
	}
	
	
	public List<Cliente> findAll() {
		return cadastroClienteRepository.findAll();
		
		}
	
	public Cliente atualizar(Cliente cliente){		
		return cliente = cadastroClienteRepository.atualizar(cliente);
	}
	
	public Cliente findByid(int id){
		return cadastroClienteRepository.findByid(id);
	}
	
	public Cliente findByidCliente(int id){
		return cadastroClienteRepository.findByidCliente(id);
	}

	public List<Cliente> filtrarCliente(Cliente cliente){
		return cadastroClienteRepository.findCliente(cliente);
	}
	
	
	

}
