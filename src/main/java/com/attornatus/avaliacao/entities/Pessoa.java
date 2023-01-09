package com.attornatus.avaliacao.entities;

import java.io.Serializable;
// import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	private String nome;
	// private Date dataDeNascimento;
	private String dataDeNascimento;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String dataDeNascimento) {
		super();
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(nome, other.nome);
	}

}
