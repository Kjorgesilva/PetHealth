package br.com.petHealth.json.response;

import java.util.List;

public class CadastroGeral {
	
	
	
	private List<AnimalResponse>listaAnimal;
	private List<EnderecoResponse>listaEndereco;
	private List<MedicoResponse>listaMedico;
	
	
	public List<AnimalResponse> getListaAnimal() {
		return listaAnimal;
	}
	public void setListaAnimal(List<AnimalResponse> listaAnimal) {
		this.listaAnimal = listaAnimal;
	}
	public List<EnderecoResponse> getListaEndereco() {
		return listaEndereco;
	}
	public void setListaEndereco(List<EnderecoResponse> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}
	public List<MedicoResponse> getListaMedico() {
		return listaMedico;
	}
	public void setListaMedico(List<MedicoResponse> listaMedico) {
		this.listaMedico = listaMedico;
	}
	
	
	
}
