package com.italigestionale.business;

import java.util.List;

import com.italigestionale.bean.Articolo;
import com.italigestionale.bean.Categoria;
import com.italigestionale.bean.Fornitore;
import com.italigestionale.bean.SottoCategoria;
import com.italigestionale.bean.User;

public interface BusinessInterface {
	
	public List<User> getListUser();

	public void insertArticolo(Articolo articolo);
	
	public List<Articolo> getAllArticoli();
	
	public List<Articolo> getArticoliBy(Articolo articolo);
	
	public Articolo getArticolo(String codice_articolo);
	
	public Articolo getArticolo(Articolo articolo);
	
//	public List<Articolo> getArticoliByFornitore(Fo fornitore);
	
	public List<Articolo> getArticoliByFornitore(String codice_fornitore);
	
	public List<Fornitore> getAllFornitori();
	
	public List<Fornitore> getFornitoreBy(Fornitore fornitore);
	
	public void insertFornitore(Fornitore fornitore);
	
	public void insertCategoria(Categoria categoria);
	
	public void insertSottoCategoria(SottoCategoria sottocategoria, Categoria categoria);
	
	public List<Categoria> getAllCategorie();
	
	public List<SottoCategoria> getAllSottoCategorie();
	
}
