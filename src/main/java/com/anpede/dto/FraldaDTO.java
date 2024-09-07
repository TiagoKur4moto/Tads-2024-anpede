package com.anpede.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.anpede.entities.Fralda;
import com.anpede.entities.RetiradaFralda;

public class FraldaDTO implements Serializable {
private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao; 
	private Integer quantidadePacote;
	private String tamanho;
	private String genero;
	private String incontinencia;
	private String periodo;
	private List<RetiradaFralda> retiradaFralda = new ArrayList<>();
	
	
	public FraldaDTO() {
		// TODO Auto-generated constructor stub
	}


	public FraldaDTO(Long id, String descricao, Integer quantidadePacote, String tamanho, String genero,
			String incontinencia, String periodo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidadePacote = quantidadePacote;
		this.tamanho = tamanho;
		this.genero = genero;
		this.incontinencia = incontinencia;
		this.periodo = periodo;
	}
	
	public FraldaDTO(Fralda entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.quantidadePacote = entity.getQuantidadePacote();
		this.tamanho = entity.getTamanho();
		this.genero = entity.getGenero();
		this.incontinencia = entity.getIncontinencia();
		this.periodo = entity.getPeriodo();
	}
	
	public FraldaDTO(Fralda entity, List<RetiradaFralda> retiradaFralda) {
		this(entity);
		this.retiradaFralda = retiradaFralda.stream().map(x -> 
		new RetiradaFralda(x.getId(), x.getQuantidade(), x.getDataRetirada(), x.getAssociado()))
				.collect(Collectors.toList());
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getQuantidadePacote() {
		return quantidadePacote;
	}


	public void setQuantidadePacote(Integer quantidadePacote) {
		this.quantidadePacote = quantidadePacote;
	}


	public String getTamanho() {
		return tamanho;
	}


	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getIncontinencia() {
		return incontinencia;
	}


	public void setIncontinencia(String incontinencia) {
		this.incontinencia = incontinencia;
	}


	public String getPeriodo() {
		return periodo;
	}


	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}


	public List<RetiradaFralda> getRetiradaFralda() {
		return retiradaFralda;
	}

	
}
