package com.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DataBaseManager;
import com.database.models.CustomerAddressDBModel;

public class CustomerAddressDao {
	private CustomerAddressDao() {
		
	}
	
	private static final String CUSTOMER_ADDRESS_QUERY="""
			Select 
			      id,
	             flat_number,
	             apartment_name,
	             street_name,
	             landmark,
	             area,
	             pincode,
	             country,
	             state
	             
	        from tr_customer_address    where id=?
			""";
	
	public static CustomerAddressDBModel getCustomerAddressInfo(int customerID) {
		CustomerAddressDBModel customeraddressDBmodel = null;
		
		try {
			Connection con = DataBaseManager.getConnection();
			PreparedStatement statement = con.prepareStatement(CUSTOMER_ADDRESS_QUERY);
			statement.setInt(1, customerID);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				customeraddressDBmodel = new CustomerAddressDBModel(result.getInt("id"),result.getString("flat_number"),result.getString("apartment_name"),result.getString("street_name"),result.getString("landmark"),result.getString("area"),result.getString("pincode"),result.getString("country"),result.getString("state"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customeraddressDBmodel;
	}
 
}
