package com.am.gestorefile.controller;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Image;
import org.zkoss.zul.Window;

public class DettaglioImageController {
	
	private String dir = "C:\\Users\\Ulixe\\Downloads";
	
	@Wire
	private Window winDettaglioImage;
	
	@Wire
	private Image dettaglioImage;
	
	@Init
	public void init(){
		dettaglioImage.setSrc(dir+"\\001.jpg");
	}

}
