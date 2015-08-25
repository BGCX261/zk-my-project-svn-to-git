package com.italigestionaleweb.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class ModalDialogController extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Listen("onClick = #nuovoFornitoreBtn")
	public void showModal(Event e){
//		System.out.println("name: "+e.getName());
		Executions.createComponents("WEB-INF/widgets/window/nuovo_fornitore.zul", null, null);
//		window.doModal();
	}
	
	@Listen("onClick = #nuovoClienteBtn")
	public void showModalCliente(Event e){
//		System.out.println("name: "+e.getName());
		Executions.createComponents("WEB-INF/widgets/window/nuovo_cliente.zul", null, null);
//		window.doModal();
	}
	
	@Listen("onClick = #nuovoArticoloBtn")
	public void showModalArticolo(Event e){
//		System.out.println("name: "+e.getName());
		Executions.createComponents("WEB-INF/widgets/window/nuovo_articolo.zul", null, null);
//		window.doModal();
	}

}
