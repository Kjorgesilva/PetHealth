package br.com.petHealth.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.petHealth.model.Endereco;
import br.com.petHealth.repository.EnderecoRepository;

public class EnderecoService implements Serializable {

	@Inject
	private EnderecoRepository enderecoRepository;

	public void insert(Endereco endereco) {
		enderecoRepository.insert(endereco);
	}

	public List<Endereco> findAll() {

		return enderecoRepository.findAll();

	}

	public Endereco findByid(int id) {

		return enderecoRepository.findByid(id);
	}

}
