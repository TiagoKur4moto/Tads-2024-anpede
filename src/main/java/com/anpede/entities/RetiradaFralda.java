package com.anpede.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_retirada_fralda")
public class RetiradaFralda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantidade;
	private LocalDate dataRetirada;
	
	@ManyToOne
	private Associado associado;
	
	@ManyToOne
	private Fralda fralda;
	
	
	public RetiradaFralda() {
		// TODO Auto-generated constructor stub
	}

	public RetiradaFralda(Long id, Integer quantidade, LocalDate dataRetirada, Associado associado) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.dataRetirada = dataRetirada;
		this.associado = associado;
	}
	
	
	
	public Fralda getFralda() {
		return fralda;
	}

	public void setFralda(Fralda fralda) {
		this.fralda = fralda;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
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
		RetiradaFralda other = (RetiradaFralda) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
