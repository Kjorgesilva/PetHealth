package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Medico;
import br.com.petHealth.model.Usuario;
import br.com.petHealth.model.Usuario.PerfilUsuario;
import br.com.petHealth.repository.MedicoRepository;
import br.com.petHealth.repository.UsuarioRepository;
import br.com.petHealth.utils.EmailUtils;
import br.com.petHealth.utils.SenhaRandom;

public class MedicoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5568468316000004345L;

	@Inject
	private MedicoRepository cadastroMedicoRepository;

	@Inject
	private UsuarioRepository loginRepository;

	@Inject
	private UsuarioService usuarioService;

	public void insert(Medico medico) {

		Usuario usuario = new Usuario();
		usuario.setEmail(medico.getEmail());
		usuario.setNome(medico.getNome());
		usuario.setSenha(SenhaRandom.getSenhaRandom());
		usuario.setLogin(medico.getEmail());
		usuario.setPerfil(PerfilUsuario.MEDICO.getId());

		loginRepository.insert(usuario);

		Usuario usuarioInserido = usuarioService.findById(usuario.getId());

		medico.setUsuario(usuarioInserido);
		cadastroMedicoRepository.insert(medico);
		EmailUtils.enviarHotmail(usuario.getEmail(), usuario.getNome(), usuario.getSenha());
		
	}

	public List<Medico> findAll() {
		return cadastroMedicoRepository.findAll();

	}

	public Medico findById(int id) {
		return cadastroMedicoRepository.findById(id);
	}

	public Medico atualizar(Medico medico) {
		return medico = cadastroMedicoRepository.atualizar(medico);
	}

	public List<Medico> filtrarMedico(Medico medico) {
		return cadastroMedicoRepository.filtrarMedico(medico);
	}
}
