package com.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DataBaseManager;
import com.database.models.CustomerProblemsDBModel;

public class CustomerProblemsDao {
	private static final String PROBLEMS_DETAILS="""
			select * from map_job_problem where tr_job_head_id=?;
			""";
	
	private CustomerProblemsDao() {
		
	}
	public static CustomerProblemsDBModel getCustomerProblem(int tr_job_head_id) {
		CustomerProblemsDBModel problems = null;
		try {
			Connection con = DataBaseManager.getConnection();
			PreparedStatement statement = con.prepareStatement(PROBLEMS_DETAILS);
			statement.setInt(1, tr_job_head_id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				problems=new CustomerProblemsDBModel(result.getInt("id"), result.getInt("tr_job_head_id"), result.getInt("mst_problem_id"), result.getString("remark"));
			}
		} catch (SQLException e) {
			
		}
		return problems;
	}

}
