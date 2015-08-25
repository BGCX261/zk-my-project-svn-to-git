package com.italigestionale.persistence.hibernate.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		
		if(sessionFactory == null) {
        	try {
        		//Utilizzato nella modalità con file di configurazione hbm per annotation non serve
//              sessionFactory = new Configuration().configure("/com/dovemangio/resources/hibernate/conf/hibernate.cfg.xml").buildSessionFactory();
        		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			} catch (Exception e) {
				System.out.println(e);
			}       	
        }
        return sessionFactory;
		
	}
	
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public static void shutdown(){
		getSessionfactory().close();
	}
	
}
