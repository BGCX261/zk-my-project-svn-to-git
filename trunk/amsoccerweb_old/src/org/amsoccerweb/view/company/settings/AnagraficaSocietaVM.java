package org.amsoccerweb.view.company.settings;

import org.amsoccerweb.hibernate.domain.AnagraficaSocieta;
import org.amsoccerweb.hibernate.domain.dao.AnagraficaSocietaDAO;
import org.zkoss.bind.annotation.Init;

public class AnagraficaSocietaVM {

	private AnagraficaSocieta as = new AnagraficaSocieta(); 
	
	@Init
	public void initSetup(){
		as = new AnagraficaSocietaDAO().getAnagraficaSocieta();
	}

	public AnagraficaSocieta getAs() {
		return as;
	}
	
}
