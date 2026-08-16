package com.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DataBaseManager;
import com.database.models.CustomerProductDBModel;

public class CustomerProductDao {
	private static String CUSTOMER_PRODUCT_QUERIES="""
			Select * from tr_customer_product    where id=?;
			""";
	
	public static CustomerProductDBModel getCustomerProductInfo(int customerID) {
		CustomerProductDBModel customer = null;
	   try {
		Connection con = DataBaseManager.getConnection();
		   PreparedStatement statement = con.prepareStatement(CUSTOMER_PRODUCT_QUERIES);
		   statement.setInt(1, customerID);
		   ResultSet result = statement.executeQuery();
		   while (result.next()) {
			   System.out.println(result.getString("imei1"));
			customer=new CustomerProductDBModel(result.getInt("id"), result.getInt("mst_model_id"),result.getString("dop"), result.getString("popurl"), result.getString("imei2"), result.getString("imei1"), result.getString("serial_number"));
		}
	} catch (SQLException e) {
		
	}
		return customer;
	}
	

}
