package helpdesk2.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import helpdesk2.domains.Tecnico;
import helpdesk2.domains.dtos.TecnicoDto;
import helpdesk2.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {
	@Autowired
	private TecnicoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDto> findById(@PathVariable Long id){
		Tecnico tecnico = service.findById(id);
		
		return ResponseEntity.ok().body(new TecnicoDto(tecnico));
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDto>> findAll(){
		List<Tecnico> list = service.findAll();
		List<TecnicoDto> listDtos = list.stream().map(obj->new TecnicoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDtos);
	}

}
