package helpdesk2.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import helpdesk2.domains.Chamado;
import helpdesk2.domains.Cliente;
import helpdesk2.domains.Tecnico;
import helpdesk2.domains.enumns.Prioridade;
import helpdesk2.domains.enumns.Status;
import helpdesk2.repositores.ChamadoRepository;
import helpdesk2.repositores.ClienteRepository;
import helpdesk2.repositores.TecnicoRepository;

@Service
public class DBService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void InstanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Marcus Aurelio", "9098766656", "marcusTeste@email.com", "admin");
		Cliente cli1 = new Cliente(null, "jose", "9088776473", "cliente@email.com", "admin");
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado1", "Primeiro chamado", tec1, cli1);
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
