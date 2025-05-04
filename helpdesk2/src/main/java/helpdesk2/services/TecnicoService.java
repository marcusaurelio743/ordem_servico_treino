package helpdesk2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import helpdesk2.domains.Tecnico;
import helpdesk2.repositores.TecnicoRepository;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Long id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
