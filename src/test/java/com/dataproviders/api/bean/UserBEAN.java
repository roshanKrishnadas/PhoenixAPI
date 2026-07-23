package com.dataproviders.api.bean;

import com.opencsv.bean.CsvBindByName;
import com.poiji.annotation.ExcelCellName;

public class UserBEAN{
	@CsvBindByName(column  ="username")
	 @ExcelCellName("username")
	private String username;
	
	 @ExcelCellName("password")
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
