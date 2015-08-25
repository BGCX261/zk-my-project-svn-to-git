package com.italigestionaleweb.reporting.jasperreport;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DataSource implements JRDataSource{

	private int index = -1;
	
	private Object[][] dataArticoli;
	private Object[][] dataArticolo;
	private Object[][] dataFornitori;
	
	
	
	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean next() throws JRException {
		index++;
		return false;
//		return (index < data);
	}

}
