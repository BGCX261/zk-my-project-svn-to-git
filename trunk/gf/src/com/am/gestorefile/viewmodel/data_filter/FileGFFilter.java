package com.am.gestorefile.viewmodel.data_filter;

public class FileGFFilter {
	
	private String name;
	private String extension;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name == null?"":name.trim();
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension == null?"":extension.trim();
	}

}
