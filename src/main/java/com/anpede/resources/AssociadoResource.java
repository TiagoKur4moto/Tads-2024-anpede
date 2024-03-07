

//CAMADA DE SERVIÇO

package com.anpede.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anpede.entities.Associado;



@RestController
@RequestMapping(value="/associados")
public class AssociadoResource {
	
	@GetMapping
	public ResponseEntity <List<Associado>> findAll(){
		List<Associado> list = new ArrayList<Associado>();
		list.add(new Associado(1L, "Claudia Andrade", "123.456.789-12",  LocalDate.parse("2002-02-21"), DateTimeFormatter.ofPattern("yyyy-mm-dd")),
				"(67)99999-1234","CLAUDIA@gamail.com","Av.Campo Grande, 132, centro"));
		return ResponseEntity.ok().body(list);
	
	}
	
}
