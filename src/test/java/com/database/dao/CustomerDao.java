package com.database.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.database.DataBaseManager;
import com.database.models.CustomerDBModel;

public class CustomerDao {
	
	private static final String CUSTOMER_DETAIL_QUERY="""
			Select * from tr_customer where id='381873';
			""";
	
	
	public static CustomerDBModel getCustomerInfo() throws SQLException {
		Connection con = DataBaseManager.getConnection();
	     Statement statement = con.createStatement();
	      ResultSet result = statement.executeQuery(CUSTOMER_DETAIL_QUERY);
	      CustomerDBModel customerDBModel=null;
	      while(result.next()) {
	    	 // System.out.println(result.getString("first_name"));
	    	  customerDBModel=new CustomerDBModel(result.getString("first_name"), result.getString("last_name"), result.getString("mobile_number"), result.getString("mobile_number_alt"), result.getString("email_id"), result.getString("email_id_alt"));
	      }
		      return   customerDBModel;   
		                
	}
}
