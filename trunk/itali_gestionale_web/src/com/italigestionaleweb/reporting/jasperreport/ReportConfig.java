package com.italigestionaleweb.reporting.jasperreport;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;

public class ReportConfig {

	private Map<String, Object> parameters;
	private JRDataSource dataSource;
	private ReportType type;
	
	public ReportConfig(String titolo, String sottotitolo){
		parameters = new HashMap<String, Object>();
		parameters.put("ReportTitle", titolo);
		parameters.put("dataFile", sottotitolo);
	}

	public ReportType getType() {
		return type;
	}

	public void setType(ReportType type) {
		this.type = type;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public JRDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(JRDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
}
