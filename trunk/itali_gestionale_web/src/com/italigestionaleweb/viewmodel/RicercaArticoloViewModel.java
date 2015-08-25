package com.italigestionaleweb.viewmodel;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

import com.italigestionale.bean.Articolo;
import com.italigestionale.bean.Fornitore;
import com.italigestionale.business.BusinessInterface;
import com.italigestionaleweb.myfactory.MyFactory;

public class RicercaArticoloViewModel {
	
	private List<Articolo> listaArticoli;
	private List<String> listFornitori;
	
	private Articolo articolo = new Articolo();
	
	@Init
	public void init(){
		
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		List<Fornitore> listaFornitoriDB = businessInterface.getAllFornitori();
		listFornitori = new ArrayList<>();
		for (Fornitore fornitore : listaFornitoriDB) {
			listFornitori.add(fornitore.getRagione_sociale());
		}
		
	}

	@Command
	public void cercaArticolo(){
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		businessInterface.getArticoliBy(articolo);
	}
	
	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	public List<String> getListFornitori() {
		return listFornitori;
	}

}
