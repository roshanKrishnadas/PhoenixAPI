package com.api.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPDemo {

	public static void main(String[] args) throws SQLException {
		HikariConfig hk=new HikariConfig();
		hk.setJdbcUrl(configManager.getProperty("DB_URL"));
		hk.setUsername(configManager.getProperty("DB_USERNAME"));
		hk.setPassword(configManager.getProperty("DB_PASSWORD"));
		hk.setMaximumPoolSize(10);
		hk.setMinimumIdle(2);
		hk.setConnectionTimeout(10000);//1*10000=10 sec
		hk.setIdleTimeout(10000);
		hk.setMaxLifetime(1800000);
		hk.setPoolName("Phoenix Test Automation Framewoork");
		
		HikariDataSource ds=new HikariDataSource(hk);
		Connection con = ds.getConnection();
		//System.out.println(con);
		
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery("Select first_name,last_name,mobile_number from tr_customer;");
		
		while(result.next()) {
			
			System.out.println(result.getString("first_name"));
		}
		     ds.close();           
	}

}
