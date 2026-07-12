package com.dataproviders.api.bean;

import com.opencsv.bean.CsvBindByName;

public class UserBEAN{
	@CsvBindByName(column  ="username")
	private String username;
	@CsvBindByName(column  ="password")
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
