package com.database.dao;

import java.sql.SQLException;

import com.api.request.model.FdCustomerData;
import com.database.models.CustomerDBModel;

public class DemoDaoRunner {

	public static void main(String[] args) throws SQLException {
		CustomerDBModel b = CustomerDao.getCustomerInfo();
		System.out.println(b);
		System.out.println(b.getFirst_name());
		System.out.println(b.getLast_name());
		FdCustomerData customer= new FdCustomerData("ros", "hos", "1234967891", "", "hos@gmail.com", "");
		System.out.println(customer.first_name());
	}

}
