package com.italigestionale.integration;

public class MyFactory {

	private static MyFactory factory = null;
	
	private IntegrationInterface itf = null;
	
	private MyFactory(){}

	public static MyFactory getFactory(){
		if(factory == null){
			factory = new MyFactory();
		}
		return factory;
	}
	
	public IntegrationInterface getInterface(){
		if(itf == null){
			itf = new IntegrationInterfaceImpl();
		}
		return itf;
	}
}
