package org.amsoccerweb.essentials;

import org.authentication.essentials.services.AuthenticationService;
import org.authentication.essentials.services.UserCredential;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class LoginController extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Textbox account;	
	@Wire
	Textbox password;
	@Wire
	Label message;
	
	AuthenticationService authService = new AuthenticationServiceImpl();
	
	@Listen("onClick=#login; onOk=#loginWin")
	public void doLogin(){
		String nm = account.getValue();
		String pd = password.getValue();
		
		if(!authService.login(nm, pd)){
			message.setValue("account or password not correct");
		}
		UserCredential cre = authService.getUserCredential();
		message.setValue("Welcome: "+cre.getName());
		message.setClass("");
	}
}
