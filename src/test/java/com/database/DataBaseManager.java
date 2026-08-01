package com.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.api.utils.configManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataBaseManager {
	public static final String DB_URL=configManager.getProperty("DB_URL");
	public static final String DB_USER_NAME=configManager.getProperty("DB_USERNAME");
	public static final String DB_PASSWORD= configManager.getProperty("DB_PASSWORD");
	public static final int MAXIMUM_POOL_SIZE=Integer.parseInt(configManager.getProperty("MAXIMUM_POOL_SIZE"));
	public static final int MINIMUM_IDLE=Integer.parseInt(configManager.getProperty("MINIMUM_IDLE"));
	public static final int CONNECTION_TIMEOUT=Integer.parseInt(configManager.getProperty("CONNECTION_TIMEOUT"));
	public static final int IDLE_TIMEOUT=Integer.parseInt(configManager.getProperty("IDLE_TIMEOUT"));
	public static final int MAX_LIFE_TIME=Integer.parseInt(configManager.getProperty("MAX_LIFE_TIME"));
	public static final String POOL_NAME=configManager.getProperty("POOL_NAME");
	public static HikariConfig hk;
	public volatile static HikariDataSource ds;// any update on this varaibales all the others threads gets update automatically volatile is there 
	
	public  static Connection con;
	
	
	private  static void initializePool() {
		
		if(ds==null) {
		synchronized (DataBaseManager.class) {
				if(ds==null) {
					hk=new HikariConfig();
					hk.setJdbcUrl(DB_URL);
					hk.setUsername(DB_USER_NAME);
					hk.setPassword(DB_PASSWORD);
					hk.setMaximumPoolSize(MAXIMUM_POOL_SIZE);
					hk.setMinimumIdle(MINIMUM_IDLE);
					hk.setConnectionTimeout(CONNECTION_TIMEOUT*1000);//1*10000=10 sec
					hk.setIdleTimeout(IDLE_TIMEOUT*1000);
					hk.setMaxLifetime(MAX_LIFE_TIME*60*1000);
					hk.setPoolName("Phoenix Test Automation Framewoork");
					ds=new HikariDataSource(hk);
				  	  
					}
			}
		
	
		}
	}
	
	public static Connection getConnection() throws SQLException {
             if(ds==null) {
            	 initializePool(); 
             }
             else if(ds.isClosed()) {
            	 throw new SQLException("Hikari Data source is closed ");
             }
			 con=ds.getConnection();
		
		return con;
	}
	
}
