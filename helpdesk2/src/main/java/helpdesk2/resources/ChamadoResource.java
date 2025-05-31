package helpdesk2.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import helpdesk2.domains.Chamado;
import helpdesk2.domains.dtos.ChamadoDto;
import helpdesk2.services.ChamadoService;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource {
	@Autowired
	private ChamadoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ChamadoDto> findById(@PathVariable Long id){
		Chamado obj = service.findById(id);
		
		return ResponseEntity.ok().body(new ChamadoDto(obj));
		
	}
	@GetMapping
	public ResponseEntity<List<ChamadoDto>> findAll(){
		List<Chamado> list = service.findAll();
		List<ChamadoDto> listDto = list.stream().map(x-> new ChamadoDto(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<ChamadoDto> created( @Valid @RequestBody ChamadoDto objDto){
		Chamado  obj = service.created(objDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
					.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ChamadoDto> update(@PathVariable Long id, @Valid @RequestBody ChamadoDto objDto){
		Chamado newChamado = service.update(id,objDto);
		
		return ResponseEntity.ok().body(new ChamadoDto(newChamado));
	}

}
