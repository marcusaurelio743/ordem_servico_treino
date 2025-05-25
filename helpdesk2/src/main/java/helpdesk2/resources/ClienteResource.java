package helpdesk2.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import helpdesk2.domains.Cliente;
import helpdesk2.domains.dtos.ClienteDto;
import helpdesk2.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> findById(@PathVariable Long id){
		Cliente Cliente = service.findById(id);
		
		return ResponseEntity.ok().body(new ClienteDto(Cliente));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll(){
		List<Cliente> list = service.findAll();
		List<ClienteDto> listDtos = list.stream().map(obj->new ClienteDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDtos);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> created(@Valid @RequestBody ClienteDto objDto){
		Cliente newObj = service.created(objDto);
		//pegando a url e o id do objeto criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ClienteDto> update(@PathVariable Long id,@Valid @RequestBody ClienteDto objDto){
		Cliente obj = service.update(id,objDto); 
		
		return ResponseEntity.ok().body(new ClienteDto(obj));
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

	

}
