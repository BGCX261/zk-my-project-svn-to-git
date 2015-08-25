package com.italigestionaleweb.controller;

import java.util.HashMap;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

import com.italigestionale.bean.Articolo;
import com.italigestionale.bean.Fornitore;

public class FornitoreController extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Fornitore fornitore = new Fornitore();
	
	@Wire
	private Window win;
	
	@Init
	public void init(){
		HashMap<Object, Object> myMap = new HashMap<>(Executions.getCurrent().getArg());
//		Fornitore curSelctedFornitore = (Fornitore)myMap.get("curSelctedFornitore");
		
		fornitore = (Fornitore)myMap.get("curSelctedFornitore");
		
		System.out.println("Init winNuovoFornitore: "+win);
//		System.out.println("curSelctedFornitore: "+curSelctedFornitore.getRagione_sociale());
	}

	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}

}
