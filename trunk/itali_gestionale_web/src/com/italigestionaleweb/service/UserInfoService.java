package com.italigestionaleweb.service;

import com.italigestionale.bean.User;

public interface UserInfoService {

	/** find user by account **/
	public User findUser(String account);
	
	/** update user **/
	public User updateUser(User user);
	
}
