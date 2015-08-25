package com.italigestionale.bean;

import java.util.List;

public class Categoria {
	
	private Integer id_categoria; 
	private String nome; 
	private List<SottoCategoria> sottoCategorie;
	
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
	public List<SottoCategoria> getSottoCategorie() {
		return sottoCategorie;
	}
	public void setSottoCategorie(List<SottoCategoria> sottoCategorie) {
		this.sottoCategorie = sottoCategorie;
	}
	
}
