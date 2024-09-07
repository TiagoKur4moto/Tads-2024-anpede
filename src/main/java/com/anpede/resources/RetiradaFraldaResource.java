package com.anpede.resources;

import java.net.URI;
import java.util.List;

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

import com.anpede.dto.RetiradaFraldaDTO;
import com.anpede.services.RetiradaFraldaService;

@RestController
@RequestMapping(value = "/retiradaFralda")
public class RetiradaFraldaResource {
	
	@Autowired
	private RetiradaFraldaService service;
	
	@GetMapping
	public ResponseEntity<List<RetiradaFraldaDTO>> findAll(){
		List<RetiradaFraldaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RetiradaFraldaDTO> findById(@PathVariable Long id){		
		RetiradaFraldaDTO dto = service.findById(id);		
		return ResponseEntity.ok().body(dto);		
	}
	
	@PostMapping
	public ResponseEntity<RetiradaFraldaDTO> insert(@RequestBody RetiradaFraldaDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(null);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<RetiradaFraldaDTO> update(@PathVariable Long id, 
											   @RequestBody	RetiradaFraldaDTO dto){
		dto = service.update(id, dto);		
		return ResponseEntity.ok().body(dto);
	}

}
