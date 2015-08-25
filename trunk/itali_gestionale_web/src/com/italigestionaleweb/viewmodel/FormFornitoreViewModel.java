package com.italigestionaleweb.viewmodel;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

import com.italigestionale.bean.Fornitore;
import com.italigestionale.business.BusinessInterface;
import com.italigestionaleweb.myfactory.MyFactory;

public class FormFornitoreViewModel{
	
	@Wire("#winNuovoFornitore")
	private Window winNuovoFornitore;
		
//	@Wire("#tabs")
//	private Tabs tabs;
	
	private Fornitore fornitore = new Fornitore();
	
	@Command
	public void submit(){
		
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		businessInterface.insertFornitore(this.getFornitore());
//		BindUtils.postGlobalCommand(null, null, FornitoriController.class, "fornitori");
		winNuovoFornitore.detach();
		
	}
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireComponents(view, this, false);
	}
	
	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}

	@Init
	public void init(){
		System.out.println("Init winNuovoFornitore: "+winNuovoFornitore);
//		System.out.println("Init tabs: "+tabs);
	}
	
	@Command
	public void closeThis(){
		winNuovoFornitore.detach();
	}

}
