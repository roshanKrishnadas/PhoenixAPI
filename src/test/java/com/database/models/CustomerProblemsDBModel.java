package com.database.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerProblemsDBModel {

	
	private int	id;
	private int tr_job_head_id;
	private int mst_problem_id;
	private String remark;

}
