package org.amsoccerweb.hibernate.domain.dao;

import java.util.List;

import org.amsoccerweb.hibernate.domain.Test;
import org.amsoccerweb.hibernate.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class TestDAO {
	
	private int idTest;

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}
	
	public List<Test> getAllTestId(){
		List<Test> allTestId = null;
		try{
			Session session = HibernateUtil.beginTransaction();
			Criteria cr = session.createCriteria(Test.class);
			allTestId = cr.list();
			HibernateUtil.CommitTransaction();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		return allTestId;
	}

}
