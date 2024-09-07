package com.anpede.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.anpede.dto.FraldaDTO;
import com.anpede.entities.Fralda;
import com.anpede.repositories.FraldaRepository;
import com.anpede.services.exceptions.DataBaseException;
import com.anpede.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FraldaService {

	@Autowired
	private FraldaRepository repository;
	
	@Transactional(readOnly = true)
	public List<FraldaDTO> findAll(){				
		List<Fralda> list = repository.findAll();
		return list.stream().map(e -> new FraldaDTO(e, e.getRetiradaFralda())).collect(Collectors.toList());		
	}

	@Transactional(readOnly = true)
	public FraldaDTO findById(Long id) {
		Optional<Fralda> obj = repository.findById(id);
		Fralda entity = obj.orElseThrow(() -> 
			new ResourceNotFoundException("O registro não localizado na base de dados"));
		return new FraldaDTO(entity);
	}
	
	@Transactional
	public FraldaDTO insert(FraldaDTO dto) {
		Fralda entity = new Fralda();
		converterDtoEmEntidade(dto, entity);					
		entity = repository.save(entity);
		return new FraldaDTO(entity);
	}
	
	@Transactional
	public FraldaDTO update(Long id, FraldaDTO dto) {
		try {
			
			Fralda entity = repository.getReferenceById(id);
			converterDtoEmEntidade(dto, entity);
				
			entity = repository.save(entity);
			return new FraldaDTO(entity);
			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("O recurso com o ID "+id
					+" não foi localizado");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O recurso com o ID "+id
					+" não foi localizado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de Integride, "
					+ "você não pode excluir este arquivo.");
		}
	}
	
	private void converterDtoEmEntidade(FraldaDTO dto, Fralda entity) {
		entity.setDescricao(dto.getDescricao());
		entity.setQuantidadePacote(dto.getQuantidadePacote());
		entity.setTamanho(dto.getTamanho());
		entity.setGenero(dto.getGenero());
		entity.setIncontinencia(dto.getIncontinencia());
		entity.setPeriodo(dto.getPeriodo());
	}
}
