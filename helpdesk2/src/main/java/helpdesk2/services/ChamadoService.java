package helpdesk2.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import helpdesk2.domains.Chamado;
import helpdesk2.domains.Cliente;
import helpdesk2.domains.Tecnico;
import helpdesk2.domains.dtos.ChamadoDto;
import helpdesk2.domains.enumns.Prioridade;
import helpdesk2.domains.enumns.Status;
import helpdesk2.repositores.ChamadoRepository;
import helpdesk2.services.exeption.ObjectNotFundExeption;


@Service
public class ChamadoService {
	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;
	
	public Chamado findById(Long id) {
		
		Optional<Chamado> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFundExeption("Objeto não encontrado id: "+id));
		
	}

	public List<Chamado> findAll() {
		
		return repository.findAll();
	}

	public Chamado created(@Valid ChamadoDto objDto) {
		
		
		return repository.save(newChamado(objDto));
	}
	
	private Chamado newChamado(ChamadoDto objDto) {
		Tecnico tecnico = tecnicoService.findById(objDto.getTecnico());
		Cliente cliente = clienteService.findById(objDto.getCliente());
		
		Chamado chamado = new Chamado();
		
		if(objDto.getId() != null) {
			chamado.setId(objDto.getId());
		}
		
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setStatus(Status.toEnum(objDto.getStatus()));
		chamado.setPrioridade(Prioridade.toEnum(objDto.getPrioridade()));
		chamado.setTitulo(objDto.getTitulo());
		chamado.setObservacoes(objDto.getObservacoes());
		
		return chamado;
	}

}
