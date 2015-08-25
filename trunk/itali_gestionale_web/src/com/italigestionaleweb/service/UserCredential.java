package com.italigestionaleweb.service;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserCredential implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String email;
	
	Set<String> roles = new HashSet<String>();

	public UserCredential(String account, String name){
		this.username = account;
		this.email = name;
	}
	
	public UserCredential(){
		this.username = "anonymous";
		this.email = "Anonymous";
		roles.add("anonymous");
	}
	
	public boolean isAnonymous() {
		return hasRole("anonymous") || "anonymous".equals(username);
	}

	public boolean hasRole(String role) {
		return this.roles.contains(role);
	}

	public void addRole(String role) {
		this.roles.add(role);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
