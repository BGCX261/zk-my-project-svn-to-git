package com.italigestionaleweb.composite;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listitem;

public class MenuItem extends Listitem implements IdSpace{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6602130924345364582L;
	
	@Wire
	private Image picture;
	@Wire
	private Label title;
	
	public MenuItem(){
		
		Executions.createComponents("/WEB-INF/composite/MenuItem.zul", this, null);
		Selectors.wireComponents(this, this, false);
		
	}

	public String getPicture() {
		return picture.getSrc();
	}

	public void setPicture(String picture) {
		this.picture.setSrc(picture);
	}

	public String getTitle() {
		return title.getValue();
	}

	public void setTitle(String title) {
		this.title.setValue(title);
	}

	
}
