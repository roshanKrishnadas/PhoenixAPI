package com.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DataBaseManager;
import com.database.models.CustomerDBModel;

public class CustomerDao {
	private CustomerDao() {
		
	}
	
	private static final String CUSTOMER_DETAIL_QUERY="""
			Select * from tr_customer where id=?
			""";
	
	
	public static CustomerDBModel getCustomerInfo(int customerId) {
		 CustomerDBModel customerDBModel=null;
		try {
			Connection con = DataBaseManager.getConnection();
			  PreparedStatement statement = con.prepareStatement(CUSTOMER_DETAIL_QUERY);
			  statement.setInt(1, customerId);
			  ResultSet result = statement.executeQuery();
			 
			  while(result.next()) {
				 // System.out.println(result.getString("first_name"));
				 
				  customerDBModel=new CustomerDBModel(result.getInt("id"),
						  result.getString("first_name"), 
						  result.getString("last_name"),
						  result.getString("mobile_number"), 
						  result.getString("mobile_number_alt"),
						  result.getString("email_id"), 
						  result.getString("email_id_alt"),
						  result.getInt("tr_customer_address_id")
						  );
			  }
			     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		 return   customerDBModel;            
	}
}
