package com.italigestionaleweb.controller;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;

import com.italigestionaleweb.bean.UtenteBean;
import com.italigestionaleweb.login.AuthenticationServiceImpl;
import com.italigestionaleweb.service.AuthenticationService;
import com.italigestionaleweb.service.UserCredential;

public class LoginController {

	private String errorMessage;
	
	private UtenteBean utente = new UtenteBean();
	
	private AuthenticationService authService = new AuthenticationServiceImpl();
	
	@NotifyChange("errorMessage")
	@Command
	public void doLogin(){
		
		if(!authService.login(utente.getUsername(), utente.getPassword())){
//			System.out.println(errorMessage.getValue());
			errorMessage = "Username o Password Errati";
			System.out.println("ERRORE DI AUTENTICAZIONE");
			return;
		}
		UserCredential cre = authService.getUserCredential();
		Executions.sendRedirect("/");
		
	}

	public UtenteBean getUtente() {
		return utente;
	}

	public void setUtente(UtenteBean utente) {
		this.utente = utente;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
