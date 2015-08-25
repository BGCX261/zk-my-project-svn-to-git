package org.amsoccerweb.view;

import java.util.ArrayList;
import java.util.List;

import org.amsoccerweb.hibernate.domain.Test;
import org.amsoccerweb.hibernate.domain.dao.TestDAO;
import org.zkoss.bind.annotation.Init;

public class HibernateTestVM {
	
	private List<Test> testsId = new ArrayList<Test>();

	@Init
	public void initSetup(){
		testsId = new TestDAO().getAllTestId();
	}
	
	public List<Test> getallTestsId() {
		return testsId;
	}

	
}
