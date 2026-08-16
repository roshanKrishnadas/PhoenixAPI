package com.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DataBaseManager;
import com.database.models.CustomerJobHeadDBModel;

public class CustomerJobHeadDAO {
	private  static final String CUSTOMER_JOB_HEAd_DETAILS="""
			select * from tr_job_head where tr_customer_id=?
			""";
	private String job_number;
	private int tr_customer_id;
	private int tr_customer_product_id;
	private int mst_service_location_id;
	private int mst_platform_id;
	private int mst_warrenty_status_id;
	private int mst_oem_id;
	
private CustomerJobHeadDAO() {
	
}
	
	public static CustomerJobHeadDBModel getCustomerJobHeadInfo(int customerID) {
		CustomerJobHeadDBModel customer=null;
		
		try {
			Connection con = DataBaseManager.getConnection();
			PreparedStatement statement = con.prepareStatement(CUSTOMER_JOB_HEAd_DETAILS);
			 statement.setInt(1, customerID);
			 ResultSet result = statement.executeQuery();
			 while(result.next()) {
				 customer=new CustomerJobHeadDBModel(result.getString("job_number"), result.getInt("tr_customer_id"), result.getInt("tr_customer_product_id"), result.getInt("mst_service_location_id"), result.getInt("mst_platform_id"), result.getInt("mst_warrenty_status_id"), result.getInt("mst_oem_id"));
				 
			 }
		} catch (SQLException e) {
			
		}
		return customer;
	}
}
