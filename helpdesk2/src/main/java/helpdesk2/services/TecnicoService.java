package helpdesk2.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import helpdesk2.domains.Pessoa;
import helpdesk2.domains.Tecnico;
import helpdesk2.domains.dtos.TecnicoDto;
import helpdesk2.repositores.PessoaRepository;
import helpdesk2.repositores.TecnicoRepository;
import helpdesk2.services.exeption.DataIntegrityViolationException;
import helpdesk2.services.exeption.ObjectNotFundExeption;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Long id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFundExeption("Objeto não encontrado Id: "+id));
	}

	public List<Tecnico> findAll() {
		
		return repository.findAll();
	}

	public Tecnico created(TecnicoDto objDto) {
		objDto.setId(null);
		validaPorCpfEmail(objDto);
		Tecnico newObj = new Tecnico(objDto);
		
		return repository.save(newObj);
	}

	private void validaPorCpfEmail(TecnicoDto objDto) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
		
		if(obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("Cpf Já cadastrado no Sistema!!");
		}
		
		obj = pessoaRepository.findByEmail(objDto.getEmail());
			if(obj.isPresent() && obj.get().getId() != objDto.getId()) {
				throw new DataIntegrityViolationException("Email Já cadastrado no Sistema!!");
			}
		
	}

	public Tecnico update(Long id, @Valid TecnicoDto objDto) {
		objDto.setId(id);
		Tecnico oldObj = findById(id);
		validaPorCpfEmail(objDto);
		oldObj = new Tecnico(objDto);
		
		
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		Tecnico obj = findById(id);
		if(obj.getChamados().size() >0) {
			throw new DataIntegrityViolationException("O tecnico Possui Ordens de serviços e não pode ser deletado !!");
		}
		
		repository.deleteById(id);
	}

}
