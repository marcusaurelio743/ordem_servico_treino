package helpdesk2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import helpdesk2.domains.Chamado;
import helpdesk2.repositores.ChamadoRepository;
import helpdesk2.services.exeption.ObjectNotFundExeption;


@Service
public class ChamadoService {
	@Autowired
	private ChamadoRepository repository;
	
	public Chamado findById(Long id) {
		
		Optional<Chamado> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFundExeption("Objeto não encontrado id: "+id));
		
	}

}
