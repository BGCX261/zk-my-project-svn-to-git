package com.italigestionale.integration;

import java.util.List;

import com.italigestionale.bean.Articolo;
import com.italigestionale.bean.Categoria;
import com.italigestionale.bean.Fornitore;
import com.italigestionale.bean.SottoCategoria;
import com.italigestionale.common.pojo.ArticoloPOJO;
import com.italigestionale.common.pojo.CategoriaPOJO;
import com.italigestionale.common.pojo.FornitorePOJO;
import com.italigestionale.common.pojo.SottoCategoriaPOJO;
import com.italigestionale.common.pojo.UserPOJO;


public interface IntegrationInterface {

	public List<UserPOJO> getListUserPOJO();
	
	public void insertArticoloPOJO(Articolo articolo);
	
	public List<ArticoloPOJO> getAllArticoliPOJO();
	
	public List<ArticoloPOJO> getArticoliPOJOBy(Articolo articolo);
	
	public ArticoloPOJO getArticoloPOJO(String codice_articolo);
	
	public ArticoloPOJO getArticoloPOJO(Articolo articolo);
	
//	public List<Articolo> getArticoliByFornitore(Fo fornitore);
	
	public List<ArticoloPOJO> getArticoliPOJOByFornitore(String codice_fornitore);	
	
	public void insertFornitorePOJO(Fornitore fornitore);
	
	public List<FornitorePOJO> getAllFornitoriPOJO();
	
	public void insertCategoriaPOJO(Categoria categoria);
	
	public void insertSottoCategoriaPOJO(SottoCategoria sottocategoria, Categoria categoria);
	
	public List<CategoriaPOJO> getAllCategoriaPOJO();
	
	public List<SottoCategoriaPOJO> getAllSottoCategoriaPOJO();
	
}
