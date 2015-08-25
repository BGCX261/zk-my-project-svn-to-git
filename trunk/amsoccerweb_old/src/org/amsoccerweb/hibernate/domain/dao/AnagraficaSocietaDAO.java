package org.amsoccerweb.hibernate.domain.dao;

import org.amsoccerweb.hibernate.domain.AnagraficaSocieta;
import org.amsoccerweb.hibernate.utilities.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class AnagraficaSocietaDAO {

	public AnagraficaSocieta getAnagraficaSocieta(){
		AnagraficaSocieta as = new AnagraficaSocieta();
		try{
			Session session = HibernateUtil.beginTransaction();
			Criteria cr = session.createCriteria(AnagraficaSocieta.class);
			as = (AnagraficaSocieta) cr.uniqueResult();
			HibernateUtil.CommitTransaction();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		return as;
	}
	
}
