package br.com.petHealth.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.petHealth.json.response.RelatorioResponse;
import br.com.petHealth.model.RespostaRelatorio;
import br.com.petHealth.service.RelatorioMedicoService;

@Path("/respostaRelatorio")
public class RespostaRelatorioWs implements Serializable {

	@Inject
	private RelatorioMedicoService relatorioService;
	private List<RespostaRelatorio> listaRelatorio;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/listaRespostaRelatorio")
	public List<RelatorioResponse> listaRelatorio() {

		System.out.println("Chegou relatorio");
		listaRelatorio = relatorioService.findAllResposta();
		List<RelatorioResponse> list = new ArrayList<>();

		for (RespostaRelatorio rel : listaRelatorio) {
			RelatorioResponse relatorio = new RelatorioResponse();

			relatorio.setId(rel.getId());
			relatorio.setRelatoriosAnimal(rel.getAnimal().getNome());
			relatorio.setRelatorioCliente(rel.getCliente().getNome());
			relatorio.setRelatoriosMedcio(rel.getMedico().getNome());
			relatorio.setRelatoriosPergunta(rel.getPergunta().getDescricao());

			list.add(relatorio);

			System.out.println(rel.getResposta());

		}

		return list;
	}

}
