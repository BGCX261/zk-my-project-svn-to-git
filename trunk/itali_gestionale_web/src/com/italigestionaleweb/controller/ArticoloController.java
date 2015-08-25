package com.italigestionaleweb.controller;

import java.io.IOException;
import java.util.HashMap;

import org.zkoss.bind.annotation.Init;
import org.zkoss.image.AImage;
import org.zkoss.zk.ui.Executions;

import com.italigestionale.bean.Articolo;
import com.italigestionale.business.BusinessInterface;
import com.italigestionaleweb.myfactory.MyFactory;

public class ArticoloController {

	private Articolo articolo = new Articolo();
	private Articolo curSelctedArticolo;
	private AImage image;
	
	@Init
	public void init(){
		
		HashMap<Object, Object> myMap = new HashMap<>(Executions.getCurrent().getArg());
		Articolo curSelctedArticolo = (Articolo)myMap.get("curSelctedArticolo");
		
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		articolo = businessInterface.getArticolo(curSelctedArticolo);
		
		try {
			image = new AImage(articolo.getNome(), articolo.getImage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Nome Articolo DETTAGLIO: "+articolo.getNome());
		
	}
	
	public Articolo getArticolo() {
		return articolo;
	}

	public Articolo getCurSelctedArticolo() {
		return curSelctedArticolo;
	}

	public void setCurSelctedArticolo(Articolo curSelctedArticolo) {
		this.curSelctedArticolo = curSelctedArticolo;
	}

	public AImage getImage() {
		return image;
	}
	
}
