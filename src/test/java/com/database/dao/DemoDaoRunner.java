package com.database.dao;

import java.sql.SQLException;

import com.database.models.CustomerProblemsDBModel;
import com.database.models.CustomerProductDBModel;

public class DemoDaoRunner {//381953

	public static void main(String[] args) throws SQLException {
	 CustomerProblemsDBModel customer = CustomerProblemsDao.getCustomerProblem(389417);
		System.out.println(customer);
	}

}
