package com.APITest;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.Search;
import com.api.services.JobService;
import com.api.utils.SpecUtil;

public class SearchAPITest {
	private JobService jobservice;
	private Search search;
	private static final String JOB_NUMBER="JOB_499244";
	
	
	@BeforeMethod(description = "instantaiting  the job service and creating the job payload")
	public void setUp() {
		jobservice=new JobService();
		search=new Search(JOB_NUMBER);
	}
	@Test(description="Verify whether search api is wrking ", groups = {"e2e","smoke","api"})
   public void search() {
		jobservice.search(Role.FD, search)
		.then()
		.spec(SpecUtil.responseSpec_OK())
		.body("message", Matchers.equalTo("Success"));
	   
   }
}
