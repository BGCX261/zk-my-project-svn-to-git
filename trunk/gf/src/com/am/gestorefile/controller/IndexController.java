package com.am.gestorefile.controller;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Image;
import org.zkoss.zul.Window;

import com.am.gestorefile.model.FileGF;
import com.am.gestorefile.utility.UtilsFileGF;

public class IndexController {
	
	private String dir = "C:\\Users\\Ulixe\\Downloads";
	private UtilsFileGF uFileGS = new UtilsFileGF();

	private List<FileGF> listaFileGS = new ArrayList<FileGF>();
	private List<String> listaEstensioni = new ArrayList<String>();
	
	private FileGF curSelctedFileGS;
	
	@Init
	public void init(){
		listaFileGS = uFileGS.getListaFile(dir);
		listaEstensioni = uFileGS.getListaEstensioni(listaFileGS);
	}
	
	@Command
	public void dettaglioFileGSBtn(){
//		Messagebox.show(curSelctedFileGS.getName(),"Dettaglio Immagine",Messagebox.OK,Messagebox.INFORMATION);
		Window win = (Window) Executions.createComponents("dettaglioImage.zul", null, null);
		win.doModal();
	}

	public List<FileGF> getListaFileGS() {
		return listaFileGS;
	}

	public List<String> getListaEstensioni() {
		return listaEstensioni;
	}

	public FileGF getCurSelctedFileGS() {
		return curSelctedFileGS;
	}

	public void setCurSelctedFileGS(FileGF curSelctedFileGS) {
		this.curSelctedFileGS = curSelctedFileGS;
	}

}
