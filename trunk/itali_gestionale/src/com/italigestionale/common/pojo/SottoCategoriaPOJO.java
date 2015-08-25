package com.italigestionale.common.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="sottocategoria")
public class SottoCategoriaPOJO {

	@Id
	@GeneratedValue
	@Column(name="id_sottocategoria")
	private Integer id_sottocategoria; 
	
	@Column(name="nome")
	private String nome; 
	
	@ManyToMany(mappedBy="sottoCategorie")
	private Set<CategoriaPOJO> categorie = new HashSet<CategoriaPOJO>();
	
	public Integer getId_sottocategoria() {
		return id_sottocategoria;
	}

	public void setId_sottocategoria(Integer id_sottocategoria) {
		this.id_sottocategoria = id_sottocategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<CategoriaPOJO> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<CategoriaPOJO> categorie) {
		this.categorie = categorie;
	}
	
}
