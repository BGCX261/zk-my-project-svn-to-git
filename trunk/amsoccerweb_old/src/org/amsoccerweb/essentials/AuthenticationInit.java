package org.amsoccerweb.essentials;

import java.util.Map;

import org.authentication.essentials.services.AuthenticationService;
import org.authentication.essentials.services.UserCredential;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

public class AuthenticationInit implements Initiator{

	AuthenticationService authService = new AuthenticationServiceImpl();
	
	@Override
	public void doInit(Page arg0, Map<String, Object> arg1) throws Exception {
		
		UserCredential cre = authService.getUserCredential();
		if(cre == null || cre.isAnonymous()){
//			Executions.sendRedirect(uri);
		}
		
	}

}
