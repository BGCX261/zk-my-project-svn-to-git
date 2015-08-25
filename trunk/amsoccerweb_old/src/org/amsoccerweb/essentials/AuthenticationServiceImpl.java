package org.amsoccerweb.essentials;

import java.io.Serializable;

import org.authentication.essentials.services.AuthenticationService;
import org.authentication.essentials.services.UserCredential;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

public class AuthenticationServiceImpl implements AuthenticationService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean login(String account, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout() {
		Session sess = Sessions.getCurrent();
		sess.removeAttribute("userCredential");
		
	}

	@Override
	public UserCredential getUserCredential() {
		Session sess = Sessions.getCurrent();
		UserCredential cre = (UserCredential)sess.getAttribute("userCredential");
		if(cre == null){
			cre = new UserCredential();
			sess.setAttribute("userCredential", cre);
		}
		return null;
	}

}
