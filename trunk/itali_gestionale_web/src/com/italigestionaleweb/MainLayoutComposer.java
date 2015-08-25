package com.italigestionaleweb;

import org.zkoss.bind.annotation.Init;
import org.zkoss.util.logging.Log;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Include;
import org.zkoss.zul.ListModelArray;

import com.italigestionaleweb.bean.MenuGroupBean;
import com.italigestionaleweb.bean.MenuItemBean;

public class MainLayoutComposer extends GenericForwardComposer<Borderlayout> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MenuGroupBean[] menuGroups;
	
	Include xcontents;

	private static final Log log = Log.lookup(MainLayoutComposer.class);
	
	// Composer Implementation
		@Override
		public void doAfterCompose(Borderlayout comp) throws Exception {
			super.doAfterCompose(comp);
			Events.postEvent("createMenuGroup", comp, null);
		}

	@Init	
	public void init(){
		createMenuGroup(this.menuGroups);
	}	
		
		
//	public void onMainCreate(Event event) {	
//		xcontents.setSrc("/fornitori/fornitori.zul");
//	}

	
	public void createMenuGroup(MenuGroupBean[] menuGroups){
		
		this.menuGroups = new MenuGroupBean[] {
				new MenuGroupBean(
					"ANAGRAFICHE",
					new ListModelArray<MenuItemBean>(
						new MenuItemBean[] {
							new MenuItemBean(
									"",
									"Fornitori"),
							new MenuItemBean(
									"",
									"Clienti"),
							new MenuItemBean(
									"",
									"Agenti")
						}
					)
				),
				
				new MenuGroupBean(
					"MAGAZZINO",
					new ListModelArray<MenuItemBean>(
						new MenuItemBean[] {
							new MenuItemBean(
									"",
									"Articoli"),
							new MenuItemBean(
									"",
									"Categorie")
						}
					)
				),
				
				new MenuGroupBean(
					"SCADENZE e PAGAMENTI",
					new ListModelArray<MenuItemBean>(
						new MenuItemBean[] {
							new MenuItemBean(
									"",
									"Scadenziario"),
							new MenuItemBean(
									"",
									"Promemoria")
						}
					)
				),

				new MenuGroupBean(
					"DOCUMENTI",
					new ListModelArray<MenuItemBean>(
						new MenuItemBean[] {
							new MenuItemBean(
									"",
									"Gestione Documenti"),
							new MenuItemBean(
									"",
									"Ordini"),
							new MenuItemBean(
									"",
									"Preventivi"),
							new MenuItemBean(
									"",
									"Vendita al pubblico")		
						}
					)
				)
			};
		
	}
	

	public MenuGroupBean[] getMenuGroups() {
		return menuGroups;
	}


	public void setMenuGroups(MenuGroupBean[] menuGroups) {
		this.menuGroups = menuGroups;
	}

}
