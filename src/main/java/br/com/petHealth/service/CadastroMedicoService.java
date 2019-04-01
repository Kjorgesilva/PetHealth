package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Medico;
import br.com.petHealth.model.Usuario;
import br.com.petHealth.model.Usuario.PerfilUsuario;
import br.com.petHealth.repository.CadastroMedicoRepository;
import br.com.petHealth.repository.UsuarioRepository;

public class CadastroMedicoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5568468316000004345L;
	
	
	@Inject
	private CadastroMedicoRepository cadastroMedicoRepository;
	
	@Inject
	private UsuarioRepository loginRepository;

	@Inject
	private UsuarioService usuarioService;
	
	
	public void insert (Medico medico){
		
		Usuario usuario = new Usuario();
		usuario.setEmail(medico.getEmail());
		usuario.setNome(medico.getNome());
		usuario.setSenha("222");
		usuario.setLogin("M" + medico.getNome());
		usuario.setPerfil(PerfilUsuario.MEDICO.getId());
		
		loginRepository.insert(usuario);
		
		Usuario usuarioInserido = usuarioService.findById(usuario.getId());
		
		medico.setUsuario(usuarioInserido);
		cadastroMedicoRepository.insert(medico);
		
	}
	
	public List<Medico> findAll() {
		return cadastroMedicoRepository.findAll();
		
		}
	
	
	public Medico findById(int id){
		
		cadastroMedicoRepository = new CadastroMedicoRepository();
		if(cadastroMedicoRepository == null){
			System.out.println("repositorio nulo");
			return null;
		}else{
			return cadastroMedicoRepository.findById(id);

		}
		
	}

	
	public Medico atualizar(Medico medico){		
		return medico = cadastroMedicoRepository.atualizar(medico);
	}
}
