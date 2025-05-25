package helpdesk2.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import helpdesk2.domains.Pessoa;
import helpdesk2.domains.Cliente;
import helpdesk2.domains.dtos.ClienteDto; 
import helpdesk2.repositores.PessoaRepository;
import helpdesk2.repositores.ClienteRepository;
import helpdesk2.services.exeption.DataIntegrityViolationException;
import helpdesk2.services.exeption.ObjectNotFundExeption;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFundExeption("Objeto não encontrado Id: "+id));
	}

	public List<Cliente> findAll() {
		
		return repository.findAll();
	}

	public Cliente created(ClienteDto objDto) {
		objDto.setId(null);
		validaPorCpfEmail(objDto);
		Cliente newObj = new Cliente(objDto);
		
		return repository.save(newObj);
	}

	private void validaPorCpfEmail(ClienteDto objDto) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
		
		if(obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("Cpf Já cadastrado no Sistema!!");
		}
		
		obj = pessoaRepository.findByEmail(objDto.getEmail());
			if(obj.isPresent() && obj.get().getId() != objDto.getId()) {
				throw new DataIntegrityViolationException("Email Já cadastrado no Sistema!!");
			}
		
	}

	public Cliente update(Long id, @Valid ClienteDto objDto) {
		objDto.setId(id);
		Cliente oldObj = findById(id);
		validaPorCpfEmail(objDto);
		oldObj = new Cliente(objDto);
		
		
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		Cliente obj = findById(id);
		if(obj.getChamados().size() >0) {
			throw new DataIntegrityViolationException("O Cliente Possui Ordens de serviços e não pode ser deletado !!");
		}
		
		repository.deleteById(id);
	}

}
