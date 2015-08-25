package com.italigestionale.business;

import java.util.ArrayList;
import java.util.List;

import com.italigestionale.bean.Articolo;
import com.italigestionale.bean.Categoria;
import com.italigestionale.bean.Fornitore;
import com.italigestionale.bean.SottoCategoria;
import com.italigestionale.bean.User;
import com.italigestionale.common.pojo.ArticoloPOJO;
import com.italigestionale.common.pojo.CategoriaPOJO;
import com.italigestionale.common.pojo.FornitorePOJO;
import com.italigestionale.common.pojo.SottoCategoriaPOJO;
import com.italigestionale.common.pojo.UserPOJO;
import com.italigestionale.integration.IntegrationInterface;
import com.italigestionale.integration.MyFactory;


public class BusinessInterfaceImpl implements BusinessInterface{

	@Override
	public void insertArticolo(Articolo articolo) {
		
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		servicesIntegration.insertArticoloPOJO(articolo);
		
	}
	
	@Override
	public List<Articolo> getAllArticoli() {
		
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		List<ArticoloPOJO> articoloPOJO = servicesIntegration.getAllArticoliPOJO();
		
		List<Articolo> listArticoli = new ArrayList<Articolo>();
		for (ArticoloPOJO artPOJO : articoloPOJO) {
			
			Articolo articolo = new Articolo(); 
			articolo.setId_articolo(artPOJO.getId_articolo());
			articolo.setCodice_articolo(artPOJO.getCodice_articolo());
			articolo.setCodice_fornitore(artPOJO.getCodice_fornitore());
			articolo.setCodice_ean_upc(artPOJO.getCodice_ean_upc());
			articolo.setNome(artPOJO.getNome());
			articolo.setFornitore(artPOJO.getFornitore());
			articolo.setGiacenza(artPOJO.getGiacenza());
			articolo.setPrenotati(artPOJO.getPrenotati());
			articolo.setRiordino(artPOJO.getRiordino());
			articolo.setScorta_minima(artPOJO.getScorta_minima());
			articolo.setUnita_di_misura(artPOJO.getUnita_di_misura());
			articolo.setCategoria(artPOJO.getCategoria());
			articolo.setSotto_categoria(artPOJO.getSotto_categoria());
			articolo.setListino_fornitore(artPOJO.getListino_fornitore());
			articolo.setSconto_fornitore(artPOJO.getSconto_fornitore());
			articolo.setPrezzo_acquisto(artPOJO.getPrezzo_acquisto());
			articolo.setSconto_medio(artPOJO.getSconto_medio());	
			articolo.setDescrizione(artPOJO.getDescrizione());
			articolo.setProduttore(artPOJO.getProduttore());
			articolo.setConfezione(artPOJO.getConfezione());
			articolo.setPeso(artPOJO.getPeso());
			articolo.setPeso_unita(artPOJO.getPeso_unita());
			articolo.setIngredienti(artPOJO.getIngredienti());
			articolo.setRegione(artPOJO.getRegione());
			articolo.setFabbricazione(artPOJO.getFabbricazione());
			articolo.setCertificazioni(artPOJO.getCertificazioni());
			
			listArticoli.add(articolo);
		}
		
		return listArticoli;
	}

	@Override
	public List<Articolo> getArticoliBy(Articolo articolo) {
		
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		List<ArticoloPOJO> listaArticoliPOJO = servicesIntegration.getArticoliPOJOBy(articolo);
		System.out.println("listaArticoliPOJO - ARticoli Trovati n° "+listaArticoliPOJO.size());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articolo getArticolo(String codice_articolo) {
		
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Articolo getArticolo(Articolo art) {
		
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		ArticoloPOJO artPOJO = servicesIntegration.getArticoloPOJO(art);
		
		Articolo articolo = new Articolo(); 
		articolo.setId_articolo(artPOJO.getId_articolo());
		articolo.setCodice_articolo(artPOJO.getCodice_articolo());
		articolo.setCodice_fornitore(artPOJO.getCodice_fornitore());
		articolo.setCodice_ean_upc(artPOJO.getCodice_ean_upc());
		articolo.setNome(artPOJO.getNome());
		articolo.setFornitore(artPOJO.getFornitore());
		articolo.setGiacenza(artPOJO.getGiacenza());
		articolo.setPrenotati(artPOJO.getPrenotati());
		articolo.setRiordino(artPOJO.getRiordino());
		articolo.setScorta_minima(artPOJO.getScorta_minima());
		articolo.setUnita_di_misura(artPOJO.getUnita_di_misura());
		articolo.setCategoria(artPOJO.getCategoria());
		articolo.setSotto_categoria(artPOJO.getSotto_categoria());
		articolo.setListino_fornitore(artPOJO.getListino_fornitore());
		articolo.setSconto_fornitore(artPOJO.getSconto_fornitore());
		articolo.setPrezzo_acquisto(artPOJO.getPrezzo_acquisto());
		articolo.setSconto_medio(artPOJO.getSconto_medio());	
		articolo.setDescrizione(artPOJO.getDescrizione());
		articolo.setProduttore(artPOJO.getProduttore());
		articolo.setConfezione(artPOJO.getConfezione());
		articolo.setPeso(artPOJO.getPeso());
		articolo.setPeso_unita(artPOJO.getPeso_unita());
		articolo.setIngredienti(artPOJO.getIngredienti());
		articolo.setRegione(artPOJO.getRegione());
		articolo.setFabbricazione(artPOJO.getFabbricazione());
		articolo.setCertificazioni(artPOJO.getCertificazioni());
		articolo.setUrl_thumb(artPOJO.getUrl_thumb());
		articolo.setUrl_thumb_max(artPOJO.getUrl_thumb_max());
		if(artPOJO.getImage() != null){
			articolo.setImage(artPOJO.getImage());
		}else{
			articolo.setImage(new byte[0]);
		}
		
		
		
		
		return articolo;
	}

	@Override
	public List<Articolo> getArticoliByFornitore(String codice_fornitore) {
		
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornitore> getAllFornitori() {

		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		List<FornitorePOJO> fornitoriPOJO = servicesIntegration.getAllFornitoriPOJO();
		
		List<Fornitore> listaFornitori = new ArrayList<Fornitore>();
		for (FornitorePOJO fornitorePOJO : fornitoriPOJO) {
			Fornitore fornitore = new Fornitore();
			fornitore.setId_fornitore(fornitorePOJO.getId_fornitore());
			fornitore.setCodice_fornitore(fornitorePOJO.getCodice_fornitore());
			fornitore.setRagione_sociale(fornitorePOJO.getRagione_sociale());
			fornitore.setIndirizzo(fornitorePOJO.getIndirizzo());
			fornitore.setCap(fornitorePOJO.getCap());
			fornitore.setCitta(fornitorePOJO.getCitta());
			fornitore.setProvincia(fornitorePOJO.getProvincia());
			fornitore.setTelefono(fornitorePOJO.getTelefono());
			fornitore.setCellulare_1(fornitorePOJO.getCellulare_1());
			fornitore.setEmail(fornitorePOJO.getEmail());
			fornitore.setSito_web(fornitorePOJO.getSito_web());
			listaFornitori.add(fornitore);
		}
		
		return listaFornitori;
	}

	@Override
	public List<Fornitore> getFornitoreBy(Fornitore fornitore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFornitore(Fornitore fornitore) {
		
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		servicesIntegration.insertFornitorePOJO(fornitore);
		
	}

	@Override
	public void insertCategoria(Categoria categoria) {
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		servicesIntegration.insertCategoriaPOJO(categoria);
	}

	@Override
	public void insertSottoCategoria(SottoCategoria sottocategoria, Categoria categoria) {
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		servicesIntegration.insertSottoCategoriaPOJO(sottocategoria, categoria);
	}

	@Override
	public List<Categoria> getAllCategorie() {
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		List<CategoriaPOJO> listaCategoriePOJO = servicesIntegration.getAllCategoriaPOJO();
		
		List<Categoria> listaCategorie = new ArrayList<Categoria>();
//		for (CategoriaPOJO categoriaPOJO : listaCategoriePOJO) {
//			Categoria categoria = new Categoria();
//			categoria.setId_categoria(categoriaPOJO.getId_categoria());
//			categoria.setNome(categoriaPOJO.getNome());
//			List<SottoCategoria> listaSottoCategorie = new ArrayList<SottoCategoria>();
//			for (SottoCategoriaPOJO sottocategoriaPOJO : categoriaPOJO.getSottoCategorie()) {
//				SottoCategoria sottoCategoria = new SottoCategoria();
//				sottoCategoria.setId_sottocategoria(sottocategoriaPOJO.getId_sottocategoria());
//				sottoCategoria.setNome(sottocategoriaPOJO.getNome());
//				sottoCategoria.setId_categoria(sottocategoriaPOJO.getCategoria().getId_categoria());
//				listaSottoCategorie.add(sottoCategoria);
//			}
//			categoria.setSottoCategorie(listaSottoCategorie);
//			listaCategorie.add(categoria);
//		}
		
		return listaCategorie;
	}

	@Override
	public List<SottoCategoria> getAllSottoCategorie() {
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		List<SottoCategoriaPOJO> listaSottoCategoriaPOJO = servicesIntegration.getAllSottoCategoriaPOJO();
		
		List<SottoCategoria> listaSottoCategorie = new ArrayList<SottoCategoria>();
//		for (SottoCategoriaPOJO sottoCategoriaPOJO : listaSottoCategoriaPOJO) {
//			SottoCategoria sottocategoria = new SottoCategoria();
//			sottocategoria.setId_categoria(sottoCategoriaPOJO.getId_sottocategoria());
//			sottocategoria.setId_sottocategoria(sottoCategoriaPOJO.getCategoria().getId_categoria());
//			sottocategoria.setNome(sottoCategoriaPOJO.getNome());
//			listaSottoCategorie.add(sottocategoria);
//		}
		
		return listaSottoCategorie;
	}

	@Override
	public List<User> getListUser() {
		IntegrationInterface servicesIntegration = MyFactory.getFactory().getInterface();
		List<UserPOJO> listaUserPOJO = servicesIntegration.getListUserPOJO();
		
		List<User> listaUser = new ArrayList<User>();
		for (UserPOJO userPOJO : listaUserPOJO) {
			User user= new User();
			user.setId_user(userPOJO.getId_user());
			user.setNome(userPOJO.getNome());
			user.setCognome(userPOJO.getCognome());
//			user.setAnno_di_nascita(userPOJO.getAnno_di_nascita());
			user.setUsername(userPOJO.getUsername());
			user.setPassword(userPOJO.getPassword());
			user.setEmail(userPOJO.getEmail());
			listaUser.add(user);
		}
		
		return listaUser;
	}
	
	

}
