package com.italigestionaleweb.login;

import java.io.Serializable;
import java.util.List;

import com.italigestionale.bean.User;
import com.italigestionale.business.BusinessInterface;
import com.italigestionaleweb.myfactory.MyFactory;
import com.italigestionaleweb.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static protected List<User> userList;
	static{
		BusinessInterface businessInterface = MyFactory.getFactory().getInterface();
		userList = businessInterface.getListUser();
	}

	@Override
	public synchronized User findUser(String username) {

		for (User user : userList) {
			if (username.equals(user.getUsername())) {
				return user;
			} 
		}
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
