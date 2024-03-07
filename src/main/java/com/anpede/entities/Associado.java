

//CAMADA DE ACESSO A DADOS


package com.anpede.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Associado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private long id;
	private String nome;
	private String CPF;
	private LocalDate dataNascimento;
	private String telefone;
	private String email;
	private String endereco;
	
	public Associado() {
	
	}

	public Associado(long id, String nome, String cPF, LocalDate dataNascimento, String telefone, String email,
			String endereco) {
		this.id = id;
		this.nome = nome;
		this.CPF = cPF;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
		Associado other = (Associado) obj;
		return id == other.id;
	}	
	
}
