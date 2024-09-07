package com.anpede.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_fralda")
public class Fralda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao; 
	private Integer quantidadePacote;
	private String tamanho;
	private String genero;
	private String incontinencia;
	private String periodo;
	
	@OneToMany(mappedBy = "fralda", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<RetiradaFralda> retiradaFralda;
	
	
	public Fralda() {
		// TODO Auto-generated constructor stub
	}


	public Fralda(Long id, String descricao, Integer quantidadePacote, String tamanho, String genero,
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

	
	public List<RetiradaFralda> getRetiradaFralda() {
		return retiradaFralda;
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fralda other = (Fralda) obj;
		return Objects.equals(id, other.id);
	}


	
	
	
}
