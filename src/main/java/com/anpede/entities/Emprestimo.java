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
@Table(name = "tb_emprestimo")
public class Emprestimo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataRetirada;
	private LocalDate dataDevolucao;
	private String motivo;
	
	@ManyToOne
	private Associado associado;
	
	@ManyToOne
	private EquipamentoItem equipamentoItem;
	
	public Emprestimo() {
		// TODO Auto-generated constructor stub
	}

	public Emprestimo(Long id, LocalDate dataRetirada, LocalDate dataDevolucao, EquipamentoItem equipamentoItem,
			String motivo) {
		super();
		this.id = id;
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
		this.equipamentoItem = equipamentoItem;
		this.motivo = motivo;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public EquipamentoItem getEquipamentoItem() {
		return equipamentoItem;
	}

	public void setEquipamentoItem(EquipamentoItem equipamentoItem) {
		this.equipamentoItem = equipamentoItem;
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
		Emprestimo other = (Emprestimo) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
