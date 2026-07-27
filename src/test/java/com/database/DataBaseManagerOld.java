package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import com.api.utils.configManager;

public class DataBaseManagerOld {
	public static final String DB_URL=configManager.getProperty("DB_URL");
	public static final String DB_USER_NAME=configManager.getProperty("DB_USERNAME");
	public static final String DB_PASSWORD= configManager.getProperty("DB_PASSWORD");
	public volatile static Connection con;// any update on this varaibales all the others threads gets update automatically volatile is there 
	
	
	public  static void createConnection() throws SQLException {
		if(con==null) {
		synchronized (DataBaseManagerOld.class) {
				if(con==null) {
				      con=DriverManager.getConnection(DB_URL,DB_USER_NAME,DB_PASSWORD);
				  	  System.out.println(con);
					}
			}
		
	
		}
	}
}
