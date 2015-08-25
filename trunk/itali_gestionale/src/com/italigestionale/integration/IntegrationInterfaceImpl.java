package com.italigestionale.integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import com.italigestionale.bean.Articolo;
import com.italigestionale.bean.Categoria;
import com.italigestionale.bean.Fornitore;
import com.italigestionale.bean.SottoCategoria;
import com.italigestionale.common.pojo.ArticoloPOJO;
import com.italigestionale.common.pojo.CategoriaPOJO;
import com.italigestionale.common.pojo.FornitorePOJO;
import com.italigestionale.common.pojo.SottoCategoriaPOJO;
import com.italigestionale.common.pojo.UserPOJO;
import com.italigestionale.persistence.hibernate.configuration.HibernateUtil;


public class IntegrationInterfaceImpl implements IntegrationInterface{

	@Override
	public void insertArticoloPOJO(Articolo articolo) {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		ArticoloPOJO articoloPOJO = new ArticoloPOJO();
		articoloPOJO.setId_articolo(articolo.getId_articolo());
		articoloPOJO.setCodice_articolo(articolo.getCodice_articolo());
		articoloPOJO.setCodice_fornitore(articolo.getCodice_fornitore());
		articoloPOJO.setCodice_ean_upc(articolo.getCodice_ean_upc());
		articoloPOJO.setNome(articolo.getNome());
		articoloPOJO.setFornitore(articolo.getFornitore());
		articoloPOJO.setGiacenza(articolo.getGiacenza());
		articoloPOJO.setPrenotati(articolo.getPrenotati());
		articoloPOJO.setRiordino(articolo.getRiordino());
		articoloPOJO.setScorta_minima(articolo.getScorta_minima());
		articoloPOJO.setUnita_di_misura(articolo.getUnita_di_misura());
		articoloPOJO.setCategoria(articolo.getCategoria());
		articoloPOJO.setSotto_categoria(articolo.getSotto_categoria());
		articoloPOJO.setListino_fornitore(articolo.getListino_fornitore());
		articoloPOJO.setSconto_fornitore(articolo.getSconto_fornitore());
		articoloPOJO.setPrezzo_acquisto(articolo.getPrezzo_acquisto());
		articoloPOJO.setSconto_medio(articolo.getSconto_medio());
		articoloPOJO.setDescrizione(articolo.getDescrizione());
		articoloPOJO.setProduttore(articolo.getProduttore());
		articoloPOJO.setConfezione(articolo.getConfezione());
		articoloPOJO.setPeso(articolo.getPeso());
		articoloPOJO.setPeso_unita(articolo.getPeso_unita());
		articoloPOJO.setIngredienti(articolo.getIngredienti());
		articoloPOJO.setRegione(articolo.getRegione());
		articoloPOJO.setFabbricazione(articolo.getFabbricazione());
		articoloPOJO.setCertificazioni(articolo.getCertificazioni());
		articoloPOJO.setUrl_thumb(articolo.getUrl_thumb());
		articoloPOJO.setUrl_thumb_max(articolo.getUrl_thumb_max());
		
		if(articolo.getUrl_thumb_max()!=null && !articolo.getUrl_thumb_max().equals("")){
			File file = new File(articolo.getUrl_thumb_max());
			byte[] bfile = new byte[(int) file.length()];
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				fileInputStream.read(bfile);
				fileInputStream.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			articolo.setImage(bfile);
			articoloPOJO.setImage(articolo.getImage());
		}
		
//		articol
		
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(articoloPOJO);
			tx.commit();
		}catch (Exception e) {
			if(tx != null){
				tx.rollback();
				e.printStackTrace();
//				return "ERROR";
			}	
		}finally{
			session.close();
		}
		
	}
	
	@Override
	public List<ArticoloPOJO> getAllArticoliPOJO() {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<ArticoloPOJO> listArticoliPOJO = session.createCriteria(ArticoloPOJO.class).list();
		return listArticoliPOJO;
		
	}

	@Override
	public List<ArticoloPOJO> getArticoliPOJOBy(Articolo articolo) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		ArticoloPOJO articoloPOJO = new ArticoloPOJO();
		articoloPOJO.setNome(articolo.getNome());
		articoloPOJO.setFornitore(articolo.getFornitore());
		List<ArticoloPOJO> listaArticoliPOJO = session.createCriteria(ArticoloPOJO.class).add(Example.create(articoloPOJO)).list();
		return listaArticoliPOJO;
	}

	@Override
	public ArticoloPOJO getArticoloPOJO(String codice_articolo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArticoloPOJO getArticoloPOJO(Articolo articolo) {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		ArticoloPOJO articoloPOJO = (ArticoloPOJO)session.createCriteria(ArticoloPOJO.class).add(Restrictions.eq("id_articolo", Integer.valueOf(articolo.getId_articolo()))).list().get(0);
		return articoloPOJO;
	}

	@Override
	public List<ArticoloPOJO> getArticoliPOJOByFornitore(String codice_fornitore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFornitorePOJO(Fornitore fornitore) {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		FornitorePOJO fornitorePOJO = new FornitorePOJO();
		fornitorePOJO.setId_fornitore(fornitore.getId_fornitore());
		fornitorePOJO.setCodice_fornitore(fornitore.getCodice_fornitore());
		fornitorePOJO.setTipologia(fornitore.getTipologia());
		fornitorePOJO.setRagione_sociale(fornitore.getRagione_sociale());
		fornitorePOJO.setTipo_ditta(fornitore.getTipo_ditta());
		fornitorePOJO.setCognome(fornitore.getCognome());
		fornitorePOJO.setNome(fornitore.getNome());
		fornitorePOJO.setIndirizzo(fornitore.getIndirizzo());
		fornitorePOJO.setCivico(fornitore.getCivico());
		fornitorePOJO.setStato(fornitore.getStato());
		fornitorePOJO.setProvincia(fornitore.getProvincia());
		fornitorePOJO.setCitta(fornitore.getCitta());
		fornitorePOJO.setCap(fornitore.getCap());
		fornitorePOJO.setTelefono(fornitore.getTelefono());
		fornitorePOJO.setFax(fornitore.getFax());
		fornitorePOJO.setCellulare_1(fornitore.getCellulare_1());
		fornitorePOJO.setCellulare_2(fornitore.getCellulare_2());
		fornitorePOJO.setPartita_iva(fornitore.getPartita_iva());
		fornitorePOJO.setCodice_fiscale(fornitore.getCodice_fiscale());
		fornitorePOJO.setEmail(fornitore.getEmail());
		fornitorePOJO.setSito_web(fornitore.getSito_web());
		fornitorePOJO.setBanca(fornitore.getBanca());
		fornitorePOJO.setAgenzia(fornitore.getAgenzia());
		fornitorePOJO.setIban(fornitore.getIban());
		fornitorePOJO.setSwift(fornitore.getSwift());
		fornitorePOJO.setConto(fornitore.getConto());
		fornitorePOJO.setBban(fornitore.getBban());
		fornitorePOJO.setCin(fornitore.getCin());
		fornitorePOJO.setAbi(fornitore.getAbi());
		fornitorePOJO.setCab(fornitore.getCab());
		fornitorePOJO.setNote(fornitore.getNote());
		
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(fornitorePOJO);
			tx.commit();
		}catch (Exception e) {
			if(tx != null){
				tx.rollback();
				e.printStackTrace();
//				return "ERROR";
			}	
		}finally{
			session.close();
		}
		
		
	}

	@Override
	public List<FornitorePOJO> getAllFornitoriPOJO() {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<FornitorePOJO> listaFornitoriPOJO = session.createCriteria(FornitorePOJO.class).list();
		return listaFornitoriPOJO;
		
	}

	@Override
	public void insertCategoriaPOJO(Categoria categoria) {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		CategoriaPOJO categoriaPOJO = new CategoriaPOJO();
		categoriaPOJO.setNome(categoria.getNome());

		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(categoriaPOJO);
			tx.commit();
		}catch (Exception e) {
			if(tx != null){
				tx.rollback();
				e.printStackTrace();
//				return "ERROR";
			}	
		}finally{
			session.close();
		}
		
	}

	@Override
	public void insertSottoCategoriaPOJO(SottoCategoria sottocategoria, Categoria categoria) {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		CategoriaPOJO categoriaPOJO = new CategoriaPOJO();
		categoriaPOJO.setId_categoria(categoria.getId_categoria());
		categoriaPOJO.setNome(categoria.getNome());
		
		SottoCategoriaPOJO sottocategoriaPOJO = new SottoCategoriaPOJO();
		sottocategoriaPOJO.setNome(sottocategoria.getNome());
//		sottocategoriaPOJO.setCategoria(categoriaPOJO);
		
		categoriaPOJO.getSottoCategorie().add(sottocategoriaPOJO);
		
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(categoriaPOJO);
			tx.commit();
		}catch (Exception e) {
			if(tx != null){
				tx.rollback();
				e.printStackTrace();
//				return "ERROR";
			}	
		}finally{
			session.close();
		}
		
	}

	@Override
	public List<CategoriaPOJO> getAllCategoriaPOJO() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<CategoriaPOJO> categoriaPOJO = session.createCriteria(CategoriaPOJO.class).list();
		return categoriaPOJO;
	}

	@Override
	public List<SottoCategoriaPOJO> getAllSottoCategoriaPOJO() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<SottoCategoriaPOJO> sottoCategoriaPOJO = session.createCriteria(SottoCategoriaPOJO.class).list();
		return sottoCategoriaPOJO;
	}

	@Override
	public List<UserPOJO> getListUserPOJO() {
		Session session = HibernateUtil.getSessionfactory().openSession(); 
		List<UserPOJO> listUserPOJO = session.createCriteria(UserPOJO.class).list();
		return listUserPOJO;
	}

}
