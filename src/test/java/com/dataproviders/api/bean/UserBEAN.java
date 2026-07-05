package com.dataproviders.api.bean;

public class UserBEAN{
	private String username;
	private String password;
	
	public UserBEAN() {
		
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "UserBEAN [username=" + username + ", password=" + password + "]";
	}

	public void setUsername(String username) {
		this.username=username;
	}
	public void setPassword(String password ) {
		this.password= password;
	}
}
