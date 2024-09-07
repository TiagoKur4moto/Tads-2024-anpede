package com.anpede.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anpede.dto.RetiradaFraldaDTO;
import com.anpede.entities.RetiradaFralda;
import com.anpede.repositories.RetiradaFraldaRepository;
import com.anpede.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RetiradaFraldaService {
	
	@Autowired
	private RetiradaFraldaRepository repository;
	
	@Transactional(readOnly = true)
	public List<RetiradaFraldaDTO> findAll(){				
		List<RetiradaFralda> list = repository.findAll();
		return list.stream().map(e -> new RetiradaFraldaDTO(e, e.getAssociado())).collect(Collectors.toList());		
	}

	@Transactional(readOnly = true)
	public RetiradaFraldaDTO findById(Long id) {
		Optional<RetiradaFralda> obj = repository.findById(id);
		RetiradaFralda entity = obj.orElseThrow(() -> 
			new ResourceNotFoundException("O registro não localizado na base de dados"));
		return new RetiradaFraldaDTO(entity);
	}
	
	@Transactional
	public RetiradaFraldaDTO insert(RetiradaFraldaDTO dto) {
		RetiradaFralda entity = new RetiradaFralda();
		converterDtoEmEntidade(dto, entity);					
		entity = repository.save(entity);
		return new RetiradaFraldaDTO(entity);
	}
	
	@Transactional
	public RetiradaFraldaDTO update(Long id, RetiradaFraldaDTO dto) {
		try {
			
			RetiradaFralda entity = repository.getReferenceById(id);
			converterDtoEmEntidade(dto, entity);
				
			entity = repository.save(entity);
			return new RetiradaFraldaDTO(entity);
			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("O recurso com o ID "+id
					+" não foi localizado");
		}
	}
	
	
	private void converterDtoEmEntidade(RetiradaFraldaDTO dto, RetiradaFralda entity) {
		entity.setQuantidade(dto.getQuantidade());
		entity.setDataRetirada(dto.getDataRetirada());
	}
}
