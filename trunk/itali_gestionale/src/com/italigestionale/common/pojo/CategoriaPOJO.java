package com.italigestionale.common.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="categoria")
public class CategoriaPOJO {

	@Id
	@GeneratedValue
	@Column(name="id_categoria")
	private Integer id_categoria; 
	
	@Column(name="nome")
	private String nome; 
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="categoria_sottocategoria", joinColumns={@JoinColumn(name="id_categoria")},inverseJoinColumns={@JoinColumn(name="id_sottocategoria")})
	private Set<SottoCategoriaPOJO> sottoCategorie = new HashSet<SottoCategoriaPOJO>();
	
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
	public Set<SottoCategoriaPOJO> getSottoCategorie() {
		return sottoCategorie;
	}
	public void setSottoCategorie(Set<SottoCategoriaPOJO> sottoCategorie) {
		this.sottoCategorie = sottoCategorie;
	}
	
}
