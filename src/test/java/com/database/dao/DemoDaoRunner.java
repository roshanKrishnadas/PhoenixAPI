package com.database.dao;

import java.sql.SQLException;

import com.database.models.CustomerProductDBModel;

public class DemoDaoRunner {//381953

	public static void main(String[] args) throws SQLException {
	 CustomerProductDBModel customer = CustomerProductDao.getCustomerProductInfo(387824);
		System.out.println(customer);
	}

}
