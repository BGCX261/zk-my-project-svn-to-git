package com.italigestionaleweb.myfactory;

import com.italigestionale.business.BusinessInterface;
import com.italigestionale.business.BusinessInterfaceImpl;


public class MyFactory {

private static MyFactory factory = null;
	
	private BusinessInterface itf = null;
	
	private MyFactory(){	
	}
	
	public static MyFactory getFactory(){
		if(factory == null){
			factory = new MyFactory();
		}
		return factory;
	}
	
	public BusinessInterface getInterface(){
		if (itf == null) {
			itf = new BusinessInterfaceImpl();
		}
		return itf;
	}

}
