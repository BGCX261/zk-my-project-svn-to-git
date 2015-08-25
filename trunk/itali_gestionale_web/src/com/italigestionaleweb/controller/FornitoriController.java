package com.italigestionaleweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;

import com.italigestionale.bean.Articolo;
import com.italigestionale.bean.Fornitore;
import com.italigestionale.business.BusinessInterface;
import com.italigestionaleweb.myfactory.MyFactory;

public class FornitoriController {
	
	private List<Fornitore> fornitori = new ArrayList<Fornitore>();
	
	private Fornitore curSelctedFornitore;
	
	@Init
	public void init(){
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		fornitori = businessInterface.getAllFornitori(); 
	}
	
	@Command
	public void nuovoFornitoreBtn(){ 
		Executions.createComponents("WEB-INF/widgets/window/nuovo_fornitore.zul", null, null);
	}
	
	@Command
	public void dettaglioFornitoreBtn(){
		System.out.println("RICHIAMATO DETTAGLIO FORNITORE");
		
		if (curSelctedFornitore != null) {
			
			Map<String, Fornitore> myMap = new HashMap<>();
			myMap.put("curSelctedFornitore", curSelctedFornitore);
			System.out.println(curSelctedFornitore.getNome());
			Executions.createComponents("WEB-INF/widgets/window/dettaglio_fornitore.zul", null, myMap);
		}else{
			Messagebox.show("Selezionare un fornitore","Dettaglio Fornitore",Messagebox.OK,Messagebox.INFORMATION);
		}
	}

	public List<Fornitore> getFornitori() {
		return fornitori;
	}

	public Fornitore getCurSelctedFornitore() {
		return curSelctedFornitore;
	}

	public void setCurSelctedFornitore(Fornitore curSelctedFornitore) {
		this.curSelctedFornitore = curSelctedFornitore;
	}

}
