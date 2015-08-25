package com.italigestionaleweb.bean;

public class MenuItemBean {
	
	private String picture;
	private String title;
	
	public MenuItemBean(){}
	
	public MenuItemBean(String picture, String title){
		this.picture = picture;
		this.title = title;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

}
