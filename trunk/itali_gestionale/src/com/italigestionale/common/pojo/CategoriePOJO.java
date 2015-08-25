package com.italigestionale.common.pojo;

import javax.persistence.Column;

public class CategoriePOJO {

	@Column(name="id_categoria")
	private Integer id_categoria;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="id_categoria_padre")
	private Integer id_categoria_padre;
	
	@Column(name="tipo")
	private String tipo;

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId_categoria_padre() {
		return id_categoria_padre;
	}

	public void setId_categoria_padre(Integer id_categoria_padre) {
		this.id_categoria_padre = id_categoria_padre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
