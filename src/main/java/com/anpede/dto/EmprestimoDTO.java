package com.anpede.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.anpede.entities.Associado;
import com.anpede.entities.Emprestimo;
import com.anpede.entities.EquipamentoItem;

public class EmprestimoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate dataRetirada;
	private LocalDate dataDevolucao;
	private EquipamentoItem equipamento;
	private String motivo;
	private Associado associado;
	
	public EmprestimoDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmprestimoDTO(Long id, LocalDate dataRetirada, LocalDate dataDevolucao, EquipamentoItem equipamento,
			String motivo, Associado associado) {
		super();
		this.id = id;
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
		this.equipamento = equipamento;
		this.motivo = motivo;
		this.setAssociado(associado);
	}
	
	public EmprestimoDTO(Emprestimo entity) {
		this.id = entity.getId();
		this.dataRetirada = entity.getDataDevolucao();
		this.dataDevolucao = entity.getDataDevolucao();
		this.equipamento = entity.getEquipamentoItem();
		this.motivo = entity.getMotivo();
		this.associado = entity.getAssociado();
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

	public EquipamentoItem getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(EquipamentoItem equipamento) {
		this.equipamento = equipamento;
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
	
	

}
