package com.italigestionaleweb.login;

import java.io.Serializable;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import com.italigestionale.bean.User;
import com.italigestionaleweb.service.AuthenticationService;
import com.italigestionaleweb.service.UserCredential;
import com.italigestionaleweb.service.UserInfoService;

public class AuthenticationServiceImpl implements AuthenticationService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserInfoService userInfoService = new UserInfoServiceImpl();

	@Override
	public UserCredential getUserCredential() {
		Session sess = Sessions.getCurrent();
		UserCredential cre = (UserCredential)sess.getAttribute("userCredential");
		if(cre == null){
			cre = new UserCredential();
			sess.setAttribute("userCredential", cre);
		}
		return cre;
	}
	
	@Override
	public boolean login(String username, String password) {
		User user = userInfoService.findUser(username);
		if(user==null || !user.getPassword().equals(password)){
			return false;
		}
		
		Session sess = Sessions.getCurrent();
		UserCredential cre = new UserCredential(user.getUsername(),user.getCognome());
		if(cre.isAnonymous()){
			return false;
		}
		sess.setAttribute("userCredential", cre);
		
		return true;
	}

	@Override
	public void logout() {
		Session sess = Sessions.getCurrent();
		sess.removeAttribute("userCredential");
	}

}
