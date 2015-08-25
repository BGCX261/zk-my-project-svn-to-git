package com.italigestionaleweb;

import java.util.List;

import javax.servlet.ServletRequest;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.web.fn.ServletFns;
import org.zkoss.web.servlet.Servlets;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Include;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelArray;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Toolbarbutton;

import com.italigestionale.bean.User;
import com.italigestionaleweb.bean.MenuGroupBean;
import com.italigestionaleweb.bean.MenuItemBean;
import com.italigestionaleweb.bean.PostBean;
import com.italigestionaleweb.composite.MenuItem;
import com.italigestionaleweb.data.FakeData;
import com.italigestionaleweb.login.AuthenticationServiceImpl;
import com.italigestionaleweb.service.AuthenticationService;

public class MainWindowVM {
	
	private ServletRequest request = ServletFns.getCurrentRequest();
	
	private boolean mobile;
	private MenuGroupBean[] menuGroups;
	private boolean menuOpen = false;
	private boolean modalShow = false;
	private String orient = "landscape";
	private User user;
	
	private String css;
	
	
	private AuthenticationService authService = new AuthenticationServiceImpl();
	
	@Wire("borderlayout#contentArea")
	private Borderlayout contentArea;
	
	public List<PostBean> getPostModel(){
		return FakeData.getPosts();
	}
	
	
	@Init
	public void init(){
		
		mobile = Servlets.getBrowser(request, "mobile") != null;
		
		if (mobile) {
			css = "css/tablet.css.dsp";
		}else{
			css = "css/desktop.css.dsp";
		}
		
		menuGroups = new MenuGroupBean[] {
				
				new MenuGroupBean(
						"MAGAZZINO",
						new ListModelArray<MenuItemBean>(
							new MenuItemBean[] {
								new MenuItemBean(
										"images/navigation/menu/articoli24.png",
										"Articoli"),
								new MenuItemBean(
										"images/navigation/menu/categorie24.png",
										"Categorie")
							}
						)
					),
				
				new MenuGroupBean(
					"ANAGRAFICHE",
					new ListModelArray<MenuItemBean>(
						new MenuItemBean[] {
							new MenuItemBean(
									"images/navigation/menu/fornitori24.png", "Fornitori"),
							new MenuItemBean(
									"images/navigation/menu/clienti24.png", "Clienti")
//							,
//							new MenuItemBean(
//									"",
//									"Agenti")
						}
					)
				),
								
				new MenuGroupBean(
					"SCADENZE e PAGAMENTI",
					new ListModelArray<MenuItemBean>(
						new MenuItemBean[] {
							new MenuItemBean(
									"images/navigation/menu/scadenziario24.png","Scadenziario"),
							new MenuItemBean(
									"images/navigation/menu/promemoria24.png","Promemoria")
						}
					)
				),

				new MenuGroupBean(
					"DOCUMENTI",
					new ListModelArray<MenuItemBean>(
						new MenuItemBean[] {
							new MenuItemBean(
									"images/navigation/menu/documenti24.png", "Gestione Documenti"),
							new MenuItemBean(
									"images/navigation/menu/fatture24.png", "Fatture"),		
							new MenuItemBean(
									"images/navigation/menu/ordini24.png", "Ordini"),
							new MenuItemBean(
									"images/navigation/menu/preventivi24.png", "Preventivi"),
							new MenuItemBean(
									"images/navigation/menu/spedizioni24.png", "Vendita al pubblico")		
						}
					)
				)
			};
		
		user = new User();
		user.setUsername(authService.getUserCredential().getUsername());
		
	}
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
		Double ie = Servlets.getBrowser(request, "ie");
		if (ie != null && ie < 8.0) {
			Clients.showNotification("This application does not support IE6/7", true);
		}
		
		Selectors.wireComponents(view, this, false);
	}
	
	public ListModel<String> getToolbarModel(){
		return new ListModelList<>(new String[]{"Nuovo","Dettaglio","Logout"});
	}
	
	@Command
	@NotifyChange({"menuOpen"})
	public void updateDeviceStatus(@BindingParam("orient") String orient){
		
		if (!mobile) menuOpen = true;
		
	}
	
	@Command
	@NotifyChange({"menuOpen"})
	public void toggleMenu() {
		menuOpen = !menuOpen;
	}
	
	@Command
	@NotifyChange("modalShow")
	public void hideModal(){
		modalShow = false;
	}
	
	@Command
	public void doLogout(){
		authService.logout();
		Executions.sendRedirect("/login.zul");
	}
	
	
	public boolean isMenuOpen() {
		return menuOpen;
	}

	public void setMenuOpen(boolean menuOpen) {
		this.menuOpen = menuOpen;
	}

	public boolean isModalShow() {
		return modalShow;
	}

	public void setModalShow(boolean modalShow) {
		this.modalShow = modalShow;
	}

	public MenuGroupBean[] getMenuGroups() {
		return menuGroups;
	}

	public void setMenuGroups(MenuGroupBean[] menuGroups) {
		this.menuGroups = menuGroups;
	}
	
	@Command
	public void showMessage(@ContextParam(ContextType.COMPONENT) Component comp,@BindingParam("pos") String pos){
		
		String msg = null;

		if (comp instanceof Listbox) {
			Listitem item = ((Listbox) comp).getSelectedItem();

			if (item instanceof MenuItem)
				msg = ((MenuItem) item).getTitle();

			((Listbox) comp).setSelectedItem(null);
			comp = item;
		} else if (comp instanceof Toolbarbutton) {
			msg = ((Toolbarbutton) comp).getLabel();
		} else
			return;
						
		System.out.println(contentArea);
		
//		Center center = contentArea.getCenter();
//		center.getChildren().clear();
//		Executions.createComponents("/WEB-INF/fornitori/fornitori.zul", center, null);
		
		Clients.showNotification(msg, Clients.NOTIFICATION_TYPE_INFO, comp, pos, 2000);
		
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}


	public User getUser() {
		return user;
	}
	
}
