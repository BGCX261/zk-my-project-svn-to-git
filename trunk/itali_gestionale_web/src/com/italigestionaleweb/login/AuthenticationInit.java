package com.italigestionaleweb.login;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import com.italigestionaleweb.service.AuthenticationService;
import com.italigestionaleweb.service.UserCredential;

public class AuthenticationInit implements Initiator{

	private AuthenticationService authService = new AuthenticationServiceImpl();
	
	public void doInit(Page page, Map<String, Object> args) throws Exception {
		
		System.out.println("AuthenticationInit RICHIAMATA");
		
		UserCredential cre = authService.getUserCredential();
		if(cre == null || cre.isAnonymous()){
			Executions.sendRedirect("/login.zul");
			return;
		}
	}
}
