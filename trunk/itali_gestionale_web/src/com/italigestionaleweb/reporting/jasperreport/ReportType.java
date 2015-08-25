package com.italigestionaleweb.reporting.jasperreport;

public class ReportType {

	private String label;
	private String value;
	
	
	public ReportType(String label, String value){
		this.value = value;
		this.label = label;
	}
	
	public String getValue() {
		return value;
	}
	public String getLabel() {
		return label;
	}
	
}
