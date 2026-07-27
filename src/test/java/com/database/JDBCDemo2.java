package com.database;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDemo2 {

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
		Connection con = DataBaseManager.getConnection(); 
		
		System.out.println(con);
	}

}
