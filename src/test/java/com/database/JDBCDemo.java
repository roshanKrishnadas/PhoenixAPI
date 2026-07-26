package com.database;

import java.sql.SQLException;

public class JDBCDemo {

	public static void main(String[] args) throws SQLException {
		/*
		 * Connection con =
		 * DriverManager.getConnection("jdbc:mysql://64.227.160.186 :3306/SR_DEV ",
		 * "srdev_ro_automation", "Srdev@123"); Statement statement =
		 * con.createStatement(); ResultSet result = statement.
		 * executeQuery("Select first_name,last_name,mobile_number from tr_customer;");
		 * while(result.next()) { String first_name= result.getString("first_name");
		 * String last_name= result.getString("last_name"); String
		 * mobile_number=result.getString("mobile_number");
		 * System.out.println(first_name + "|" + last_name + "|" + mobile_number); }
		 */
		DataBaseManager.createConnection(); 
		long startTime=System.currentTimeMillis();
		for(int i=1;i<=10000;i++) {
		DataBaseManager.createConnection(); 
		DataBaseManager.createConnection(); 
		DataBaseManager.createConnection(); 
		DataBaseManager.createConnection(); 
		}
		long endTime=System.currentTimeMillis();
		System.out.println("totalDuration " + (endTime-startTime) + "ms");
	}

}
