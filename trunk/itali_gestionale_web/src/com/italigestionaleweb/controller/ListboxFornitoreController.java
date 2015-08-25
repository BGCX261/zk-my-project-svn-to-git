package com.italigestionaleweb.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import com.italigestionale.bean.Fornitore;
import com.italigestionale.business.BusinessInterface;
import com.italigestionaleweb.myfactory.MyFactory;

public class ListboxFornitoreController extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ListModel<Fornitore> fornitoriModel;
	
	public ListboxFornitoreController(){
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		fornitoriModel = new ListModelList<Fornitore>(businessInterface.getAllFornitori());
	}

	public ListModel<Fornitore> getFornitoriModel() {
		return fornitoriModel;
	}

}
