package com.italigestionaleweb.controller;

import java.awt.Button;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.event.MouseEvent;

import com.italigestionale.bean.Articolo;
import com.italigestionale.business.BusinessInterface;
import com.italigestionaleweb.myfactory.MyFactory;
import com.italigestionaleweb.reporting.jasperreport.ReportConfig;
import com.italigestionaleweb.reporting.jasperreport.ReportType;
import com.oracle.jrockit.jfr.EventDefinition;

public class ArticoliController {

	private List<Articolo> articoli = new ArrayList<Articolo>();
	
	private Articolo curSelctedArticolo;
	
	private ReportConfig reportConfig;
	
	@Init
	public void init(){
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		articoli = businessInterface.getAllArticoli();
	}

	@Command
	public void dettaglioArticoloBtn(){
		
		System.out.println("RICHIAMATO DETTAGLIO ARTICOLO");
		
		if (curSelctedArticolo != null) {
			
			Map<String, Articolo> myMap = new HashMap<>();
			myMap.put("curSelctedArticolo", curSelctedArticolo);
			System.out.println(curSelctedArticolo.getNome());
			Executions.createComponents("WEB-INF/widgets/window/dettaglio_articolo.zul", null, myMap);
		}else{
			Messagebox.show("Selezionare un articolo","Dettaglio Articolo",Messagebox.OK,Messagebox.INFORMATION);
		}
		
		
	}
	
	@Command
	public void eliminaArticoloBtn(){
		
		System.out.println("RICHIAMATO ELIMINA ARTICOLO");
		
		if (curSelctedArticolo != null) {
			
			Map<String, Articolo> myMap = new HashMap<>();
			myMap.put("curSelctedArticolo", curSelctedArticolo);
			System.out.println(curSelctedArticolo.getNome());
			Executions.createComponents("WEB-INF/widgets/window/elimina_articolo.zul", null, myMap);
			
		}else{
			Messagebox.show("Selezionare un articolo","Elimina Articolo",Messagebox.OK,Messagebox.INFORMATION);
		}
		
		
	}
	
	@Command
	public void nuovoArticoloBtn(){
		Executions.createComponents("WEB-INF/widgets/window/nuovo_articolo.zul", null, null);
	}
	
	@Command
	public void cercaArticoloBtn(){
		Executions.createComponents("WEB-INF/widgets/window/cerca_articoli.zul", null, null);
	}
	
	@Command
	public void stampaArticoloBtn(){
		if (curSelctedArticolo != null) {
			reportConfig = new ReportConfig(curSelctedArticolo.getNome(), "");
			reportConfig.setType(new ReportType("PDF","pdf"));
		}else{
			Messagebox.show("Selezionare un articolo","Stampa Articolo",Messagebox.OK,Messagebox.INFORMATION);
		}
	}

	
	public Articolo getCurSelctedArticolo() {
		return curSelctedArticolo;
	}

	public void setCurSelctedArticolo(Articolo curSelctedArticolo) {
		this.curSelctedArticolo = curSelctedArticolo;
	}

	public List<Articolo> getArticoli() {
		return articoli;
	}
	
}
