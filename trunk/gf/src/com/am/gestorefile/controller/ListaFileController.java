package com.am.gestorefile.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import com.am.gestorefile.model.FileGF;
import com.am.gestorefile.utility.UtilsFileGF;

public class ListaFileController extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ListModel<FileGF> listaFileModel;
	
	private UtilsFileGF uFileGS;
	
	private String dir = "C:\\Users\\Ulixe\\Downloads";

	public ListaFileController(){
//		uFileGS.getListaFile(dir);
		listaFileModel = new ListModelList<>(uFileGS.getListaFile(dir));
	}

	public ListModel<FileGF> getListaFileModel() {
		return listaFileModel;
	}
	

}
