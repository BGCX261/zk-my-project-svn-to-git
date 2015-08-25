package com.italigestionaleweb.menu;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ModalMenuController extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Listen("onClick = #fornitoriBtn")
	public void showModalWindow(Event e){
		Window window = (Window)Executions.createComponents("/fornitori/fornitore.zul", null, null);
		System.out.println(e);
		window.doModal();
	}

}
