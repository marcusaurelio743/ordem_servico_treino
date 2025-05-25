package helpdesk2.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
